package com.mono.util;

public class Dinero {
	private int dinero;
	public Dinero() {
		this(0);
	}
	public Dinero(int dinero) {
		this.dinero = dinero;
	}
	public int getDinero() {
		return dinero;
	}
	public void addDinero(int cantidad) {		
		dinero += cantidad;
	}
	
	public void sustraerDinero(int cantidad) {
		dinero -= cantidad;
	}
	public boolean sinDinero() {
		return dinero < 0;
	}
}