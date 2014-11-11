package com.juego.mono;

import java.util.Random;

import com.mono.util.Ver;



public class Tablero {
	private int turnoActual = 0;
	private int cantJugadores = 0;
	private Jugador[] jugadores;
	private Casillero[] casilleros;
	String[] names = new String[] 
			{ "guitara PRS", "guitarra Gibson", "guitarra Fender", "guitarra Ibanez", "guitarra Jackson", 
			"guitarra Peavy", "guitarra BB Rich","Gretsch","Yamaha","Taylor", "amplificado Marshall",
			"amplificador Vox", "amplificador Mesa Boogie",
			"amplificador Fender", "amplificador Orange", "pedal Wha-Wha", "pedal Chorus", "pedal Delay"};
	
	
	public Tablero(int cantJugadores, int casillas) {
		jugadores = new Jugador[cantJugadores];
		casilleros = new Casillero[casillas];
		this.cantJugadores = cantJugadores;
		for(int i = 0;i < jugadores.length;i++){
			jugadores[i] = new Jugador(i, "Jugador " + (i + 1));
		}		
	}
	

	public Casillero movimientoJugador(Jugador player, int face) {
		return movimientoJugador(player, face, true);
	}	
	
	public void precioCasillas(int pos ,int precio){
		Random rand = new Random();
					
		casilleros[pos] = new Casillero(
		" " + names[rand.nextInt(names.length)],precio);			
		}
	
	
	private Casillero movimientoJugador(Jugador jugador, int valorTiro, boolean contar) {
		if(jugador.enBancaRota()){ 
			return casilleros[jugador.getPosicionActual()]; 
			}
		int nuevaPosicion = avanzarPosicion(jugador.getPosicionActual() + valorTiro);
		jugador.setPosicion(nuevaPosicion);		
		casilleros[nuevaPosicion].estadoDelCasillero(jugador, this);
		if(jugador.getDinero().sinDinero()){
			Ver.ver(jugador, jugador.getNombreJugador() + " "
					+ "no le alcanzo, se ha quedado sin dinero \n"
					+ "		 "
					+ "y se lo termino afanando !");
			jugador.setBancaRota(true);
		}else{
			if(contar){
				jugador.nextTurno();
			}
		}
		return casilleros[nuevaPosicion];
	}
	
	
	public boolean hayGanador() {
		int enJuego = 0;
		for(Jugador player:jugadores){
			if(!player.enBancaRota())
				enJuego++;		
		}		
		return enJuego <= 1;
	}
	
	public Jugador getWinner() {
		if(!hayGanador()){ return null; }
		for(Jugador player:jugadores){
			if(!player.enBancaRota()){ return player; }
		}
		return null;
	}

	public int avanzarPosicion(int posicion) {
		return posicion % casilleros.length;
	}
	
	public Jugador getJugadorActual() {
		return jugadores[turnoActual];
	}
	
	public Jugador[] getJugadores() {
		return jugadores;
	}
	
	public void siguienteTurno() {
		if(++turnoActual >= jugadores.length)
			turnoActual = 0;
	}
	
	public Jugador getJugador(int id) {
			return jugadores[id];
	}
	
	public int getTotalCasillas() {
		return casilleros.length;
	}
	public int getCantJugadores() {
		return cantJugadores;
	}


	public void setCantJugadores(int cantJugadores) {
		this.cantJugadores = cantJugadores;
	}
	
}