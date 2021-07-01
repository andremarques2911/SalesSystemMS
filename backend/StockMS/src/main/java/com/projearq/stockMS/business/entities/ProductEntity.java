package com.projearq.stockMS.business.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

}