package com.talha.northwind.core.utilities.result;

public class DataResult<T> extends Result {

	private T data;
	
	public DataResult(boolean state, String message, T data) {
		super(state, message);
		this.data = data;
	}
	
	public DataResult(boolean state, T data) {
		super(state);
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

}
