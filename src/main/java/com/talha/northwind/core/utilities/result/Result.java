package com.talha.northwind.core.utilities.result;

public class Result {
	private boolean state;
	private String message;

	public Result(boolean state, String message) {
		this(state);
		this.message = message;
	}
	
	public Result(boolean state) {
		this.state = state;
	}
	
	public boolean isState() {
		return state;
	}

	public String getMessage() {
		return message;
	}
	
}
