package com.juego.mono;
import com.mono.util.Ver;

public class Casillero {
	private int precioCasillero;
	private int propietarioCasillero = -1;
	private String nombre;
	
	public Casillero(String nombre, int precio) {
		this.nombre = nombre;
		this.precioCasillero = precio;
	}
	
	public void setPropietarioCasillero(int propietario) {
		this.propietarioCasillero = propietario;
	}
	
	public int getPrecioCasillero() {
		return precioCasillero;
	}
	
	public void estadoDelCasillero(Jugador numJugador, Tablero tablero) {
	
		if (propietarioCasillero < 0 && numJugador.getDinero().getDinero()>0){			
			Ver.ver(numJugador, numJugador.getNombreJugador() +					
					" fue al casillero "+ numJugador.getPosicionActual()+ " y compro " 
					+ getNombreCasillero() + " por $" + precioCasillero);			
			propietarioCasillero = numJugador.getID();
			numJugador.getDinero().sustraerDinero(precioCasillero);		
			}
		
		else 
			{
				if(propietarioCasillero != numJugador.getID()){
					int lost = precioCasillero / 10;
					Ver.ver(numJugador, numJugador.getNombreJugador() + 
												
							" fue al casillero "+ numJugador.getPosicionActual()+
							" y perdio $" + lost + 
							" \n                "
							+ " por cobro de alquiler del instrumento o guitarra del " + 
							tablero.getJugador(propietarioCasillero).getNombreJugador());
					numJugador.getDinero().sustraerDinero(lost);
					tablero.getJugador(propietarioCasillero).getDinero().addDinero(lost);
				}
			}
		
			
	}
	public String getNombreCasillero() {
		return nombre;
		}
}