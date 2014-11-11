package com.coloreo.mapa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;


/**
* Esta clase crea un mapa objetos de tipo Zona, para luego ser coloreados. 
* @author: Rodolfo Vargas V.* 
*/

public class Mapa {

	private ArrayList<Zona> zonas;
	private TreeMap<Zona,Integer> colores;	
	
	//atributo creado con el fin de atrapar la cantidad de colores utilizados
	//para cada instancia de Clase Mapa. 
	private int coloresUsados;
	
	
	public Mapa(){
		zonas = new ArrayList<Zona>();
		colores = new TreeMap<Zona,Integer>();
		coloresUsados = 0;
		}

	/**
	 * Agregar un pais al mapa
	 * @param z : Zona
	 */
	public void agregarZona(Zona z){
		zonas.add(z);		
		colores.put(z, 0);
	}

	
	/**
	 * @param z : Zona
	 * @param color : Integer
	 */
	public void pintar(Zona z,Integer color){
		colores.put(z,color);
	}

	/** 
	 * @param z : Zona
	 * @return devolver color de la zona(pais)
	 */
	public Integer colorZona(Zona z){
		return colores.get(z);
	}

	/**
	 * @param i : int
	 * @return devolver nombre de la zona en la posicion i
	 */
	public Zona iesima(int i){
		return zonas.get(i);
	}


	/**	  
	 * @param z1 : Zona
	 * @param z2 : Zona
	 */
	public void relacionarZonas(Zona z1,Zona z2){
		zonas.get(zonas.indexOf(z1)).agregarLimitrofe(z2);
		zonas.get(zonas.indexOf(z2)).agregarLimitrofe(z1);
	}	
	
	@Override
	public String toString(){
		String ret = "";		
		for (int i=0;i<zonas.size();i++){
			ret = ret + "color --> ["+colorZona(iesima(i)).toString()+"]" + iesima(i).toString()  ;
			ret = ret + "\n" ;
			
			}
		ret += "cantidad de colores usados: ";
		return ret;
		}
	
	
	
	/************************Metodos Obligatorios*********************
	 * ***************************************************************/

	public void colorear(){
		if(this.zonas==null)
			throw new RuntimeException("El Mapa esta vacio");
		else{
			//antes de comenzar con un coloreo, se ordena el mapa
			//segun su grado(cantidad de paises limitrofes) de mayor a menor
			this.ordenPorGrado();			
			for(int i = 0; i<this.zonas.size();i++){				
				int color = colorValido(this.iesima(i));
				this.pintar(zonas.get(i), color);
				if(coloresUsados<color)			
					this.coloresUsados = color;								
			}		
		}
  }	
	
	
	
	public boolean verificarColoreo(){	
		boolean bandera = true;		
		Iterator<Zona> it = colores.keySet().iterator();		
		while(it.hasNext()&&bandera){				
			Zona puntero = it.next();
			int colorDelPais = colores.get(puntero);				
			for(int i=0; i<puntero.getLimitrofes().size(); i++ ){				
				if(colorDelPais==colorZona(puntero.getLimitrofes().get(i)))					
					bandera =false;			
			}
		}
		return bandera;
	}
	
	
	public int cantColoreo(){
		return this.coloresUsados;
	}
	
	
	/********************Metodos Auxiliares Privados******************
	 * ***************************************************************/
	
	private int colorValido(Zona zona) {	
		//variable utilizada para devolver el color apropiado
		int colorCandidato  = 1;	
		//almacena posicion de la zona a colorer.
		int posZona = this.zonas.indexOf(zona); 
		//recorre solamente zonas coloreadas, dsicriminando zonas aun no pintadas		
		for(int i=0; i<posZona;i++){
			if(!zona.getLimitrofes().contains(this.zonas.get(i)))	{	
				colorCandidato = obtenerColorCandidatoOk(						
						obtenerColoresUsados(this.zonas.indexOf(this.iesima(i+1)),
						this.zonas.indexOf(zona), zona),colorCandidato);
					break;
			}			
			colorCandidato +=1;		
			}	
		
		return colorCandidato;
	}
	
	
	/**	
	 * verificar que el color pasado como argumento no sea un color ya pintado
	 * en alguno de sus paises limitrofes, de ser asi pasar al siguiente color.
	 * @return devolver ColorCanditado   
	 */
	private int obtenerColorCandidatoOk(ArrayList<Integer> paleta, int colorCandidato){	
		//comienza a verificar con el primer color de la zona que no es
		//limitrofe con la misma.
		int colorOK = colorCandidato;
		for(int colorPaleta=0; colorPaleta<paleta.size();colorPaleta++){			
			if(!paleta.contains(colorOK))
				return colorOK;						
			colorOK +=1;		
		}
		return colorOK;		
	}	
	
	/**
	 * @return devolver una lista de colores usados por sus paises limitrofes
	 * de zona
	 */
	private ArrayList<Integer> obtenerColoresUsados(int comienzo,int fin,Zona zona) {		
		//almacena el color de cada pais limitrofe de la variable zona
		ArrayList<Integer> paletaDeColores = new ArrayList<Integer>();
		//recorre a partir de la posicion del pais pintado + 1, que no es limitrofe con zona
		//hasta la posicion de la zona
		for(int i=comienzo; i<fin;i++){			
			if(zona.getLimitrofes().contains(this.zonas.get(i)))
				paletaDeColores.add(colorZona(this.zonas.get(i)));			
		}	
		return paletaDeColores;				
	}
	
	/**
	 * Ordenar las zonas de mayor a menor, segun su 
	 * grado (Cantidad de paises limitrofes)
	 */
	private void ordenPorGrado() {
		for(int i=1;i<zonas.size();i++){
			int aux= zonas.get(i).getGradoVertice();
			Zona z = iesima(i);
			int j =i;
			for(;j>0&&aux>(zonas.get(j-1).getGradoVertice());j--)
				zonas.set(j, zonas.get(j-1));
			zonas.set(j, z);
		}
		
	}
	
	/**************************Metodos Obsoletos***********************
	 * ****************************************************************/
//	public int cantColoreo(){
//		int coloresUsados =1;	
//		Iterator<Zona> it = colores.keySet().iterator();
//		while(it.hasNext()){			
//			if(this.colores.containsValue(coloresUsados))		
//				coloresUsados += 1;
//			it.next();
//		}
//		return coloresUsados-1;
//	}
		


}