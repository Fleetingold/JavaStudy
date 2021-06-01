package com.designpattern.builder;

public class MealBuilder {

	public Meal prepareVegMeal() {
		// TODO Auto-generated method stub
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}

	public Meal prepareNonVegMeal() {
		// TODO Auto-generated method stub
		Meal meal = new Meal();
		meal.addItem(new ChickerBurger());
		meal.addItem(new Pepsi());
		return meal;
	}

}
