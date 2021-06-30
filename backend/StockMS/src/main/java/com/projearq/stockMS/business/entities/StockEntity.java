package com.projearq.sistemavendas.negocio.entidades;

import javax.persistence.*;

@Entity
@Table(name = "stock")
public class StockEntity {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "stock_id_seq", sequenceName = "stock_id_seq")
    @GeneratedValue(generator = "stock_id_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "stock_id")
	private Long id;

	private int availableQuantity;

    @OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	private ProductEntity product;

    public Stock() {}

    public static class Builder {
        private Long id = null;
        private int availableQuantity = 0;
        private ProductEntity product = null;

        public Builder() {}
		
        public Builder availableQuantity(int availableQuantity) {this.availableQuantity = availableQuantity; return this;}

        public Builder product(ProductEntity product) {this.product = product; return this;}

        public Stock build() {return new Stock(this);}

    }

    private Stock(Builder builder) {
        this.id = builder.id;
        this.availableQuantity = builder.availableQuantity;
        this.product = builder.product;
    }

    public Long getId() {return this.id;}

    public void setId(Long id) {
        this.id = id;
    }

    public int getavailableQuantity() {return this.availableQuantity;}

    public void setavailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public ProductEntity getproduct() {return this.product;}

    public void setproduct(ProductEntity product) {
        this.product = product;
    }
}
