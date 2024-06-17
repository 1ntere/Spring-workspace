package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Goods {
	private int goodsId;
	private String goodsName;
	private int goodsPrice;
	private int goodsQuantity;
}