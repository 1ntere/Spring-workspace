package com.shoppingmall.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Goods {
	private int goods_id;
	private String goods_name;
	private int goods_price;
	private int goods_quantity;
}
