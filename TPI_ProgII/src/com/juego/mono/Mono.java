package com.juego.mono;

import com.mono.util.Dado;

public class Mono {
	Dado dado = new Dado();
	Tablero tablero;
	private int casilleros;
	private String ganador = "";
	
	public Mono(int casilleros){
		this.casilleros = casilleros;
	}

	
	public void agregarJugadores(int jugadores){
		tablero = new Tablero(jugadores, this.casilleros);
		
	}
	
	public void agregarCasilla(int pos, int precio){
		tablero.precioCasillas(pos,precio);
	}

	public void jugar() {	
		while (!esteJuegoTermino()){
			if(!tablero.getJugadorActual().enBancaRota()){
				int valorTiro = tablero.getJugadorActual().tiroDado(dado);
				tablero.movimientoJugador(tablero.getJugadorActual(), valorTiro);		
			}		
			tablero.siguienteTurno();			
			if(tablero.hayGanador()){						
					this.ganador = tablero.getWinner().getNombreJugador();
					break;
			}			
		}		
	}
	
	
		public String ganador(){
			return this.ganador;	
	}
	

	public boolean esteJuegoTermino() {
		for(Jugador j:tablero.getJugadores()){
			if(j.getTurnosTotales() <1000) {
				return false; }
		}
		return true;
	}

	
}