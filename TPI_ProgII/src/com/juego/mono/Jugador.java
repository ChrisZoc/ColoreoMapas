package com.juego.mono;

import com.mono.util.Dado;
import com.mono.util.Dinero;
import com.mono.util.Ver;

public class Jugador {
	private int cantTurno = 0;
	private int posicion = 0;
	private int id;
	private String nombre;	
	private boolean bancarota = false;
	private Dinero dinero = new Dinero(1000);
	
	public Jugador(int id, String name) {
		this.id = id;
		this.nombre = name;
	}	
	public int getTurnosTotales() {
		return cantTurno;
	}
	public int tiroDado(Dado dado) {
		int face = dado.getCara();
		Ver.ver(this, getNombreJugador() + " tiro el dado... y salio " + face);
		return face;
	}
	public int getPosicionActual() {
		return posicion;
	}
	public void setPosicion(int position) {
		this.posicion = position;
	}
	public void nextTurno() {
		cantTurno++;
	}
	public String getNombreJugador() {
		return nombre;
	}
	public Dinero getDinero() {
		return dinero;
	}
	public int getID() {
		return id;
	}
	public void setBancaRota(boolean bancaRota) {
	this.bancarota = bancaRota;
	}
	public boolean enBancaRota() {
		return bancarota;
	}
}