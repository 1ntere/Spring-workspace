package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Drinks {
	private int drinksId;
	private String drinksName;
	private int drinksPrice;
	private int drinksQuantity;
}
