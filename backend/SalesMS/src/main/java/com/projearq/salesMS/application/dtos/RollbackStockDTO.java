package com.projearq.salesMS.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RollbackStockDTO implements Serializable {

    private Long code;
    private int ammount;

}
