package com.coloreo.mapa;


/********************************************************************
 * @DESARROLLADOR Rodolfo Vargas V.
 * @FECHA ENTREGA:  15/09/2014
 * @PROGRAMACION_II  TP1
 * @CLIENTE: Biblioteca UNGS
 * @Detalles: Sitema que realiza un coloreo apropiado para mapas planares
 * 			  utilizando la menor cantidad de colores posibles.
 ********************************************************************/


public class Test {
	public static void main(String[] args) {	
		testAmericaNorte();
		testAmericaSur();
		testAmericaCentral();	
		testAfrica();
	}	
		
	
	public static void testAmericaNorte(){
		Mapa ame = new Mapa();

		Zona eeuu = new Zona("Estados Unidos");
		Zona mex = new Zona("Mexico");
		Zona can = new Zona("Canada");
		
		ame.agregarZona(mex);
		ame.agregarZona(eeuu);
		ame.agregarZona(can);
		
		ame.relacionarZonas(eeuu, mex);		
		ame.relacionarZonas(can, eeuu);
		
		ame.colorear();		
		
		//***************Salida por Consola****************/
		//*************************************************/
		System.out.println("AMERICA DEL NORTE\n"+ ame.toString());		
		System.out.println(ame.cantColoreo());
		System.out.println();
		System.out.println("*********************");
		System.out.println("La verificacion del coloreo de"
				          + " AMERICA DEL NORTE es: "+ame.verificarColoreo());
		System.out.println("*********************");
		System.out.println();
		
	}
	
	
	public static void testAmericaSur(){

		Mapa surA=new Mapa();
		
		Zona venezuela= new Zona("Venezuela");
		Zona colombia= new Zona("Colombia");
		Zona ecuador= new Zona("Ecuador");
		Zona guyana= new Zona("Guyana");
		Zona surinam= new Zona("Surinam");
		Zona guayanaFrancesa= new Zona("Guayana Francesa");
		Zona brasil= new Zona("Brasil");
		Zona peru= new Zona("Peru");
		Zona bolivia= new Zona("Bolivia");
		Zona paraguay= new Zona("Paraguay");
		Zona chile= new Zona("Chile");
		Zona argentina= new Zona("Argentina");
		Zona uruguay= new Zona("Uruguay");
		surA.agregarZona(venezuela);
		surA.agregarZona(colombia);
		surA.agregarZona(ecuador);
		surA.agregarZona(guyana);
		surA.agregarZona(surinam);
		surA.agregarZona(guayanaFrancesa);
		surA.agregarZona(brasil);
		surA.agregarZona(peru);
		surA.agregarZona(bolivia);
		surA.agregarZona(paraguay);
		surA.agregarZona(chile);
		surA.agregarZona(argentina);
		surA.agregarZona(uruguay);
		
		surA.relacionarZonas(venezuela, colombia);
		surA.relacionarZonas(venezuela, guyana);
		surA.relacionarZonas(venezuela, brasil);
		surA.relacionarZonas(colombia, ecuador);
		surA.relacionarZonas(colombia, peru);
		surA.relacionarZonas(colombia, brasil);
		surA.relacionarZonas(ecuador, peru);
		surA.relacionarZonas(peru, brasil);
		surA.relacionarZonas(peru, bolivia);
		surA.relacionarZonas(peru, chile);
		surA.relacionarZonas(bolivia, brasil);
		surA.relacionarZonas(bolivia,paraguay);
		surA.relacionarZonas(bolivia, argentina);
		surA.relacionarZonas(bolivia,chile);
		surA.relacionarZonas(chile,argentina );
		surA.relacionarZonas(argentina,paraguay);
		surA.relacionarZonas(argentina,uruguay);
		surA.relacionarZonas(argentina,brasil);
		surA.relacionarZonas(uruguay,brasil);
		surA.relacionarZonas(paraguay,brasil);
		surA.relacionarZonas(brasil,guyana);
		surA.relacionarZonas(guyana,surinam);
		surA.relacionarZonas(surinam,guayanaFrancesa);
		surA.relacionarZonas(brasil,surinam);
		surA.relacionarZonas(brasil, guayanaFrancesa);
		
		surA.colorear();
		
		
		//***************Salida por Consola****************/
		//*************************************************/
		System.out.println("****************");
		System.out.println("AMERICA DEL SUR: \n"+surA.toString());		
		System.out.println(surA.cantColoreo());			
		System.out.println("****************");
		System.out.println("La verificacion del coloreo "
				+ " de Amer.DEL SUR es: "+surA.verificarColoreo());
		System.out.println("****************");
		System.out.println();
		
	}			
	
	
	public static void testAmericaCentral(){
		Mapa central = new Mapa();
		Zona gua = new Zona("Guatemala");		
		Zona hon = new Zona("Honduras");
		Zona bel = new Zona("Belice");		
		Zona cr = new Zona("Costa Rica");
		Zona pan = new Zona("Panama");
		Zona nic = new Zona("Nicaragua");
		Zona cub = new Zona("Cuba");
		Zona sal = new Zona("El Salvador");
		Zona hai = new Zona("Haiti");
		Zona jam = new Zona("Jamaica");
		Zona rep = new Zona("Republica Dominicana");
		Zona pr  = new Zona("Puerto Rico");
		
		central.agregarZona(gua);
		central.agregarZona(hon);
		central.agregarZona(bel);
		central.agregarZona(cr);
		central.agregarZona(pan);
		central.agregarZona(nic);
		central.agregarZona(cub);
		central.agregarZona(sal);
		central.agregarZona(hai);
		central.agregarZona(jam);
		central.agregarZona(rep);
		central.agregarZona(pr);
	
		
		central.relacionarZonas(gua, bel);
		central.relacionarZonas(hai, rep);
		//central.relacionarZonas(pr, null);
		central.relacionarZonas(gua, hon);
		//central.relacionarZonas(cub, null);
		central.relacionarZonas(pan, cr);
		central.relacionarZonas(hon, nic);	
		central.relacionarZonas(sal, hon);
		central.relacionarZonas(sal, gua);
		//central.relacionarZonas(jam, null);
		central.relacionarZonas(cr, nic);
		
		central.colorear();	
		
	
		//***************Salida por Consola****************/
		//*************************************************/
		System.out.println("****************");
		System.out.println("AMERICA CENTRAL: \n"+central.toString());
		System.out.println(central.cantColoreo());
		System.out.println("****************");
		System.out.println("La verificacion del Coloreo "
				+ " de Amer. Central es: "+central.verificarColoreo());
		System.out.println("****************");
		System.out.println();
	}
	
	
	
	/**
	 * Test de Africa, de la muerte
	 */
	public static void testAfrica(){
		Mapa afr = new Mapa();
		Zona sudA = new Zona("Sudafrica");
		Zona mos = new Zona("Mosambique");
		Zona sim = new Zona("Simbabue");
		Zona bod = new Zona("Bodsuana");
		Zona nam = new Zona("Namibia");
		Zona mal = new Zona("Malaui");
		Zona sam = new Zona("Sambia");
		Zona ang = new Zona("Angola");
		Zona tan = new Zona("Tanzania");
		Zona con = new Zona("Rep Congo");
		Zona rua = new Zona("Ruanda");
		Zona bur = new Zona("Burundi");
		Zona gab = new Zona("Gabon");
		Zona uga = new Zona("Uganda");
		Zona ken = new Zona("Kenia");
		Zona som = new Zona("Somalia");
		Zona eti = new Zona("Etiopia");
		Zona sudanS = new Zona("Sudan del Sur");
		Zona cent = new Zona("CentroAfica");
		Zona cam = new Zona("Camerun");
		Zona gin = new Zona("Ginea Ecuatorial");		
		//Zona eri = new Zona("Eritrea");
		Zona sud = new Zona("Sudan");
		Zona chad = new Zona("Chad");
		Zona nig = new Zona("Nigeria");
		Zona egi = new Zona("Egipto");
		Zona lib = new Zona("Libia");
		Zona niger = new Zona("Niger");
		Zona tun = new Zona("Tunes");
		Zona arg = new Zona("Argelia");
		Zona mar = new Zona("Marruecos");
		Zona mali = new Zona("Mali");
		Zona mau = new Zona("Mauritania");
		Zona sen = new Zona("Senegal");
		//Zona gam = new Zona("Gambia");
		Zona ginB = new Zona("Guinea Bisau");
		Zona ginea = new Zona("Guinea");
		Zona sie = new Zona("Sierra Leona");
		Zona libe = new Zona("Liberia");
		Zona cos = new Zona("Costa de Marfil");
		Zona gan = new Zona("Ghana");
		Zona burqui = new Zona("Burkina Faso");
		Zona tog = new Zona("Togo");
		Zona ben = new Zona("Benin");
		
		
		afr.agregarZona(sudA);
		afr.agregarZona(mos);
		afr.agregarZona(sim);
		afr.agregarZona(bod);
		afr.agregarZona(nam);
		afr.agregarZona(mal);
		afr.agregarZona(sam);
		afr.agregarZona(ang);
		afr.agregarZona(tan);
		afr.agregarZona(con);
		afr.agregarZona(rua);
		afr.agregarZona(bur);
		afr.agregarZona(gab);
		afr.agregarZona(uga);
		afr.agregarZona(ken);
		afr.agregarZona(som);
		afr.agregarZona(eti);
		afr.agregarZona(sudanS);
		afr.agregarZona(cent);
		afr.agregarZona(cam);
		afr.agregarZona(gin);		
		//afr.agregarZona(eri);
		afr.agregarZona(sud);
		afr.agregarZona(chad);
		afr.agregarZona(nig);
		afr.agregarZona(egi);
		afr.agregarZona(lib);
		afr.agregarZona(niger);
		afr.agregarZona(tun);
		afr.agregarZona(arg);
		afr.agregarZona(mar);
		afr.agregarZona(mali);
		afr.agregarZona(mau);
		afr.agregarZona(sen);
		//afr.agregarZona(gam);
		afr.agregarZona(ginB);
		afr.agregarZona(ginea);
		afr.agregarZona(sie);
		afr.agregarZona(libe);
		afr.agregarZona(cos);
		afr.agregarZona(gan);
		afr.agregarZona(burqui);
		afr.agregarZona(tog);
		afr.agregarZona(ben);
		
		
		//Paises limitrofes de Sudafrica
		afr.relacionarZonas(sudA, bod);
		afr.relacionarZonas(sudA, nam);
		afr.relacionarZonas(sudA, sim);
		afr.relacionarZonas(sudA, mos);	
		afr.relacionarZonas(nam, bod);
		afr.relacionarZonas(nam, ang);
		afr.relacionarZonas(nam, sam);		
		afr.relacionarZonas(bod, sim);	
		afr.relacionarZonas(sim, mos);
		afr.relacionarZonas(sim, sam);		
		afr.relacionarZonas(mos, mal);
		afr.relacionarZonas(mos, sam);		
		afr.relacionarZonas(mal, sam);
		afr.relacionarZonas(mal, tan);		
		afr.relacionarZonas(sam, tan);
		afr.relacionarZonas(sam, ang);
		afr.relacionarZonas(sam, con);		
		afr.relacionarZonas(ang, con);		
		afr.relacionarZonas(tan, con);
		afr.relacionarZonas(tan, bur);
		afr.relacionarZonas(tan, rua);
		afr.relacionarZonas(tan, uga);
		afr.relacionarZonas(tan, ken);		
		afr.relacionarZonas(con, gab);
		afr.relacionarZonas(con, cent);
		afr.relacionarZonas(con, cam);
		afr.relacionarZonas(con, sudanS);
		afr.relacionarZonas(con, uga);
		afr.relacionarZonas(con, rua);
		afr.relacionarZonas(con, bur);		
		afr.relacionarZonas(uga, rua);		
		afr.relacionarZonas(uga, ken);
		afr.relacionarZonas(uga, sudanS);	
		afr.relacionarZonas(ken, som);
		afr.relacionarZonas(ken , eti);		
		afr.relacionarZonas(ken, sudanS);	
		afr.relacionarZonas(som, eti);	
		afr.relacionarZonas(eti, sudanS);
		afr.relacionarZonas(eti, sud);		
		afr.relacionarZonas(sudanS, sud);
		afr.relacionarZonas(sudanS, cent);	
		afr.relacionarZonas(cent, sud);
		afr.relacionarZonas(cent, chad);
		afr.relacionarZonas(cent, cam);	
		afr.relacionarZonas(cam, chad);
		afr.relacionarZonas(cam, nig);
		//afr.relacionarZonas(som, eti);	
		afr.relacionarZonas(gab, gin);
		afr.relacionarZonas(gin, cam);			
		afr.relacionarZonas(sud, egi);
		afr.relacionarZonas(sud, chad);
		afr.relacionarZonas(sud, lib);	
		afr.relacionarZonas(chad, lib);
		afr.relacionarZonas(chad, niger);
		afr.relacionarZonas(chad, nig);		
		afr.relacionarZonas(nig, niger);
		afr.relacionarZonas(nig, ben);		
		afr.relacionarZonas(egi, lib);		
		afr.relacionarZonas(lib, tun);
		afr.relacionarZonas(lib, arg);		
		afr.relacionarZonas(niger, lib);
		afr.relacionarZonas(niger, arg);
		afr.relacionarZonas(niger, mali);	
		afr.relacionarZonas(ben, niger);
		afr.relacionarZonas(ben , burqui);
		afr.relacionarZonas(ben, tog);	
		afr.relacionarZonas(tog, burqui);
		afr.relacionarZonas(tog, gan);	
		afr.relacionarZonas(gan, burqui);
		afr.relacionarZonas(gan, cos);		
		afr.relacionarZonas(cos, burqui);
		afr.relacionarZonas(cos, libe);
		afr.relacionarZonas(cos, ginea);
		afr.relacionarZonas(cos, mali);		
		afr.relacionarZonas(libe, sie);
		afr.relacionarZonas(libe, ginea);	
		afr.relacionarZonas(sie, ginea);	
		afr.relacionarZonas(ginea, mali);
		afr.relacionarZonas(ginea, sen);
		afr.relacionarZonas(ginea, ginB);
		afr.relacionarZonas(ginB, sen);		
		afr.relacionarZonas(burqui, mali);	
		afr.relacionarZonas(mali, arg);
		afr.relacionarZonas(mali,mau);	
		afr.relacionarZonas(mali, sen);		
		afr.relacionarZonas(mau, mar);
		afr.relacionarZonas(mau, arg);		
		afr.relacionarZonas(arg, mar);		
		afr.relacionarZonas(tun, arg);
		

		afr.colorear();
	
		//***************Salida por Consola****************/
		//*************************************************/
		System.out.println("*********************");
		System.out.println("AFRICA\n"+ afr.toString());		
		System.out.println(afr.cantColoreo());
		System.out.println("*********************");
		System.out.println("La verificacion del coloreo "
				+ "de AFRICA es: "+afr.verificarColoreo());
		System.out.println("*********************");
		System.out.println();
		
		
		
		
		
		
		
		
	}

}