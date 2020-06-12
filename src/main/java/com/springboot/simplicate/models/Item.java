package com.springboot.simplicate.models;

import java.util.List;

public class Item {

	private List<Datum> data = null;
	private Object errors;
	private Object debug;

	public List<Datum> getData() {
		return data;
	}

	public void setData(List<Datum> data) {
		this.data = data;
	}

	public Object getErrors() {
		return errors;
	}

	public void setErrors(Object errors) {
		this.errors = errors;
	}

	public Object getDebug() {
		return debug;
	}

	public void setDebug(Object debug) {
		this.debug = debug;
	}
}
