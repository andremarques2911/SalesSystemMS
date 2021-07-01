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
@Table(name = "stock")
public class StockEntity {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "stock_id_seq", sequenceName = "stock_id_seq")
    @GeneratedValue(generator = "stock_id_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "stock_id")
	private Long id;

	private int availableAmmount;

    @OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	private ProductEntity product;

}
