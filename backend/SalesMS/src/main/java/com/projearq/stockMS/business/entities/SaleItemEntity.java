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
@Table(name = "sale_itens")
public class SaleItemEntity {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "id_sale_item_seq", sequenceName = "id_sale_item_seq")
    @GeneratedValue(generator = "id_sale_item_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_sale_item")
    private Long id;

    private double ammount;

    private double unitPrice;

    private double tax;

    @Column(name = "id_product", nullable = false)
    private Long productId;

//    @OneToOne
//    @JoinColumn(name = "id_product", nullable = false)
//    private ProductEntity product;

    //    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_sale", nullable = false)
    private SaleEntity sale;

}
