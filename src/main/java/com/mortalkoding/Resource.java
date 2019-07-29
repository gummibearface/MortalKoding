package com.mortalkoding;

public abstract class Resource {
	
	private String _name = "";	
	private double _amount = 0;
	
	public Resource(String aName, double amount) {
		set_name(aName);
		set_amount(amount);
	}
	
	public Resource() {
		
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public double get_amount() {
		return _amount;
	}

	public void set_amount(double _amount) {
		this._amount = _amount;
	}
	
	//A total amount of resources required fore ach monster (15 resources) spread across any type

}
