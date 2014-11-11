package com.juego.mono;

/********************************************************************
 * @DESARROLLADORES Rodolfo Vargas V.
 * @FECHA ENTREGA: 15/09/2014
 * @PROGRAMACION_II  TP1
 * @CLIENTE: Programacion II
 * @Detalles: Sistema que simula el clasico juego Monopolio
 ********************************************************************/

public class App {
	public static void main(String[] args) {	
		
		//cantidad de casilleros
		Mono mono = new Mono(40);
		
		mono.agregarJugadores(2);
		mono.agregarCasilla(0,100);
		mono.agregarCasilla(1,110);
		mono.agregarCasilla(2,133);
		mono.agregarCasilla(3,120);
		mono.agregarCasilla(4, 32);
		mono.agregarCasilla(5,114);
		mono.agregarCasilla(6, 103);
		mono.agregarCasilla(7,113);
		mono.agregarCasilla(8,100);
		mono.agregarCasilla(9,110);
		mono.agregarCasilla(10,143);
		mono.agregarCasilla(11,120);
		mono.agregarCasilla(12, 132);
		mono.agregarCasilla(13,154);
		mono.agregarCasilla(14, 103);
		mono.agregarCasilla(15,113);		
		mono.agregarCasilla(16,100);
		mono.agregarCasilla(17,180);
		mono.agregarCasilla(18,143);
		mono.agregarCasilla(19,120);		
		mono.agregarCasilla(20,100);
		mono.agregarCasilla(21,120);
		mono.agregarCasilla(22,143);
		mono.agregarCasilla(23,120);
		mono.agregarCasilla(24, 132);
		mono.agregarCasilla(25,154);
		mono.agregarCasilla(26, 103);
		mono.agregarCasilla(27,130);
		mono.agregarCasilla(28,100);
		mono.agregarCasilla(29,110);
		mono.agregarCasilla(30,123);
		mono.agregarCasilla(31,120);
		mono.agregarCasilla(32, 110);
		mono.agregarCasilla(33,124);
		mono.agregarCasilla(34, 103);
		mono.agregarCasilla(35,133);		
		mono.agregarCasilla(36,100);
		mono.agregarCasilla(37,110);
		mono.agregarCasilla(38,123);
		mono.agregarCasilla(39,120);
	
		
		while(mono.ganador() == ""){	
			mono.jugar();
		}		
		System.out.println("************************************");
	System.out.println("El jugador: "+mono.ganador()+" ha GANADO!!! *");
		System.out.println("************************************");
		
	}
}