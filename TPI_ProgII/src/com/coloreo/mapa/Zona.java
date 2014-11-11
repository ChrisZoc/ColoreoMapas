package com.coloreo.mapa;
import java.util.ArrayList;

/**
 * Clase TDA Zona, utilizado como  base para formar Mapas
 * @implements Comparable: Para poder comparar zonas según su nombre,
 * para la colocación de paises no repetidos en un mapa
 * @author Martin Pustiknic
 *
 */
public class Zona implements Comparable<Zona>{
	String nombre;
	
	//atributo agregado: la idea coyuntural del algoritmo 
	//antes de comenzar con el coloreo, era la de 
	//ordenar los paises segun el valor de su grado, 
	//es decir la cantidad de paises limitrofes que tenia el mismo,
	//acto seguido comenzar con el coloreo de la lista ya ordenada
	private int gradoVertice;
	private ArrayList<Zona> limitrofes;
	
	/**
	 * @param nombre: String
	 */
	public Zona(String nombre){
		this.nombre = nombre;
		this.gradoVertice = 0;		
		limitrofes = new ArrayList<Zona>();
	}
	
	/** 
	 * @param z: Zona
	 */
	public void agregarLimitrofe(Zona z){		
		limitrofes.add(z);
		gradoVertice +=1;
	}
	
	


	public ArrayList<Zona> getLimitrofes() {
		return limitrofes;
	}

	/**
	 * Devolver la cantidad de paises que limitan con el mismo
	 * @return grado(cantiad de paises limitrofes)
	 */
	public int getGradoVertice(){		
		return gradoVertice;}
	
	
	@Override
	public String toString(){
		String ret = "";		
		ret = nombre + ": ";		
		for (int i=0;i<limitrofes.size();i++){
			ret = ret + limitrofes.get(i).nombre;
			ret = ret + ",";
		}
			
		return ret;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zona other = (Zona) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	public int compareTo(Zona z) {
		return nombre.compareTo(z.nombre);
	}

}