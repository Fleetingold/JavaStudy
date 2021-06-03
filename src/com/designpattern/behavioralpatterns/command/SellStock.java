package com.designpattern.behavioralpatterns.command;

public class SellStock implements Order {
	private Stock abcStock;

	public SellStock(Stock abcStock) {
		super();
		this.abcStock = abcStock;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		abcStock.sell();
	}
}