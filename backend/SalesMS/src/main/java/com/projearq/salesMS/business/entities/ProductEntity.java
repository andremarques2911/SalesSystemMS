package com.projearq.salesMS.business.entities;

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
    @SequenceGenerator(allocationSize = 1, name = "id_product_seq", sequenceName = "id_product_seq")
    @GeneratedValue(generator = "id_product_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_product")
    private Long id;

    @Column
    private Long code;

    @Column
    private String description;

    @Column
    private double unitValue;

}