package com.projearq.salesMS.adapters.configurations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Receiver {
//    @Autowired
//    private ServicoCotacao servicoCotacao;

    public void receiveMessage(String message) {
        String dados[] = message.split(",");
        log.info("Received <" + message + ">");
//        servicoCotacao.novaCotacao(dados[0], dados[1],Double.parseDouble(dados[2]));
    }
}