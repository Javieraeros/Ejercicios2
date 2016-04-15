package ejerciciosSegundoTrimestre;
public class testMiArray {
	
	public static void main (String args[]) {
		//Comprobación de gets y sets
		miArray<String> javi=new miArray();
		javi.setTamanyo(6);
		javi.setElemento(5,"se");
		javi.setElemento(4,"Javi");
		javi.setTamanyo(7);
		javi.setElemento(6,"aburre");
		Paco.pinta(javi.getElemento(4)+" "+javi.getElemento(5)+" "+javi.getElemento(6));
		javi.setTamanyo(5);
		Paco.pinta(javi.getElemento(4));
		
		//Comprobación Ordenar
		miArray<Fecha> javiF=new miArray(5,2);
		Fecha miFecha=new Fecha(23,01,1996);
		Fecha miFecha2=new Fecha(22,10,1994);
		Fecha miFecha3=new Fecha(19,11,1992);
		Fecha miFecha4=new Fecha(15,8,1992);
		Fecha miFecha5=new Fecha(24,02,2009);
		Fecha miFecha6=new Fecha(25,02,1995);
		
		javiF.setElemento(0,miFecha);
		javiF.setElemento(1,miFecha2);
		javiF.setElemento(2,miFecha3);
		javiF.setElemento(3,miFecha4);
		javiF.setElemento(4,miFecha5);
		
		
		for(int i=0;i<javiF.getTamanyo();i++){
			Paco.pinta(javiF.getElemento(i));
		}
		
		
		javiF.ordenaArray();
		
		
		for(int i=0;i<javiF.getTamanyo();i++){
			Paco.pinta(javiF.getElemento(i));
		}
		
		//Comprobación añadir
		javiF.aniadeElemento(miFecha6);
		Paco.pinta("");
		for(int i=0;i<javiF.getTamanyo();i++){
			Paco.pinta(javiF.getElemento(i));
		}
		
		//Comprobación Buscar ordenado
		
		Paco.pinta(javiF.buscaElemento(miFecha5));
		
		//Comprobación Buscar desordenado
		
		miArray<Rombo> javiR=new miArray(3,3);
		Rombo r1=new Rombo(4,8);
		Rombo r2=new Rombo(2,1);
		Rombo r3=new Rombo(1,3);
		Rombo r4=new Rombo(2,5);
		Rombo r5=new Rombo(1,3);
		Rombo r6=new Rombo(2,0.5);
		Rombo r7=new Rombo(6,1);
		Rombo noEncontrar=new Rombo(3,1);
		Rombo encontrar=new Rombo(6,1);
		javiR.aniadeElemento(r1);
		javiR.aniadeElemento(r2);
		javiR.aniadeElemento(r3);
		javiR.aniadeElemento(r4);
		javiR.aniadeElemento(r5);
		javiR.aniadeElemento(r6);
		javiR.aniadeElemento(r7);
		Paco.pinta("Mostramos el array de rombos");
		for(int i=0;i<javiR.getTamanyo();i++){
			Paco.pinta(javiR.getElemento(i));
		}
		Paco.pinta("Buscamos el elemento que sabemos que no vamos a encontrar: "+noEncontrar);
		Paco.pinta(javiR.buscaElemento(noEncontrar));
		Paco.pinta("Buscamos el elemento que sabemos que vamos a encontrar: "+encontrar);
		Paco.pinta(javiR.buscaElemento(encontrar));
		Paco.pinta("Sin embargo, si ordenamos y buscamos el elemento: "+noEncontrar+" vemos que si lo encuentra, por qué?");
		javiR.ordenaArray();
		for(int i=0;i<javiR.getTamanyo();i++){
			Paco.pinta(javiR.getElemento(i));
		}
		Paco.pinta("\n"+javiR.buscaElemento(noEncontrar)+"\nAdemás,como podemos comprobar, no nos indica el primer elemento, por qué?");
		/* NECESITO ECLIPSE YAAAAAAAAAAAAAAAA (para automatizar los test y así no tener que estar comprobando continuamente cada cambio
		 * que hago en la clase miArray)*/
		
		/*miArray<Object> javiO=new miArray(5);    No puedo porque Object no puede usarse en tipo E
		javiO.setElemento(0,miFecha);
		javiO.setElemento(1,r1);*/
	}
}

