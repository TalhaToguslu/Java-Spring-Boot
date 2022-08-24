package com.talha.northwind.core.utilities.result;

public class ErrorResult extends Result {

	public ErrorResult(boolean state, String message) {
		super(false, message);
	}

	public ErrorResult() {
		super(false);
	}
}
