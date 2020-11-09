package com.example.beans;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import io.quarkus.arc.DefaultBean;

public class FoodFactory {

	@Produces
	@DefaultBean
	Food vegFood = new VegFood();

	@Produces
	@Named("non-veg")
	public Food getNonVegFood() {
		// ...
		NonVegFood nonVegFood = new NonVegFood();
		// ...
		return nonVegFood;
	}

}
