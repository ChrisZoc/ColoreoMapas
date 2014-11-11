package com.mono.util;

import com.juego.mono.Jugador;


public class Ver {
	public static void ver(Jugador jugador, String msg) {
		System.out.println("[Turno " + (jugador.getTurnosTotales() + 1) + "]"
				+ " [$" 
				+ jugador.getDinero().getDinero() + "] " + msg);
	}
}