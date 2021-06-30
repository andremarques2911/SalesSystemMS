package com.projearq.stockMS.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {

    private Long id;
    private int availableAmmount;
    private Long codProd;

}
