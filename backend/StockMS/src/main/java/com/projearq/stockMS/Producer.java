package com.projearq.stockMS;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public double custo(String de,String para,int quantidade){
        // Faz uma requisição síncrona para o serviço de cotação
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://servCotacao:8080/cotacoes/cotacao?de=real&para=dolar"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        double taxa = Double.parseDouble(response.body());
        return taxa * quantidade;
    }


    public double efetivaVenda(String de,String para,int quantidade){
        // Faz uma requisição assíncrona para o serviço de cotação
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://servCotacao:8080/cotacoes/cotacaoEfetiva?de=real&para=dolar"))
                .build();

        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result=null;
        try {
            result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
            System.exit(0);
        }

        Double custo = Double.parseDouble(result);

        return custo * quantidade;
    }

    public double efetivaVariasVendas(String de,String para,int quantidade){
        // Faz uma requisição assíncrona para o serviço de cotação
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://servCotacao:8080/cotacoes/cotacaoEfetiva?de=real&para=dolar"))
                .build();

        List<CompletableFuture<HttpResponse<String>>> respostas = new LinkedList<>();
        double total = 0.0;
        // Gera 10 operações de venda e acumula o total
        for(int i=0;i<10;i++){
            respostas.add(client.sendAsync(request, HttpResponse.BodyHandlers.ofString()));
        }
        // Vai somando as respostas
        for(CompletableFuture<HttpResponse<String>> resp:respostas){
            String result = "";
            try {
                result = resp.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
                System.exit(0);
            }

            Double custo = Double.parseDouble(result);
            total = total + (custo*quantidade);
            quantidade += 10;
        }
        return total;
    }

    public void novaCotacao(String de,String para,double valor){
        String msg = de+","+para+","+valor;
        System.out.println("Sending message: "+msg);
        rabbitTemplate.convertAndSend("spring-boot-exchange", "cotacoes.nova", msg);
    }
}
