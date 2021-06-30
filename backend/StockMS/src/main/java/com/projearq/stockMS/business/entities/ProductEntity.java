package com.projearq.sistemavendas.negocio.entidades;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {

	@Id
    @SequenceGenerator(allocationSize = 1, name = "product_id_seq", sequenceName = "product_id_seq")
    @GeneratedValue(generator = "product_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id")
    private Long id;

	private Long code;

	private String description;

	private double unitPrice;

    public ProductEntity() {}

    public static class Builder {
		private Long id = null;
        private Long code = null;
        private String description = null;
        private double unitPrice = 0.0;

        public Builder() {}

        public Builder code(Long code) {this.code = code; return this;}

        public Builder description(String description) {this.description = description; return this;}

        public Builder unitPrice(double unitPrice) {this.unitPrice = unitPrice; return this;}

        public ProductEntity build() {return new ProductEntity(this);}
    }
	private ProductEntity(Builder builder) {
		this.id = builder.id;
		this.code = builder.code;
		this.description = builder.description;
		this.unitPrice = builder.unitPrice;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

}