package com.projearq.salesMS.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private Long code;
    private String description;
    private double price;
    private int ammount;

}
