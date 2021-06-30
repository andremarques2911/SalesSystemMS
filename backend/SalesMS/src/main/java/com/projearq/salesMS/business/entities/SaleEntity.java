package com.projearq.salesMS.business.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class SaleEntity {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "id_sale_seq", sequenceName = "id_sale_seq")
    @GeneratedValue(generator = "id_sale_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_sale")
    private Long id;

    @Column
    private Date date;

}
