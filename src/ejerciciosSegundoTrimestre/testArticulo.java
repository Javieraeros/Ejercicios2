package ejerciciosSegundoTrimestre;

public class testArticulo {
	
	public static void main (String args[]) {
		Articulo pene=new Articulo("consolador",150,25,10,"Artículo de gran utilidad en el mercado de la masturbación",10);
		//Paco.pinta(pene.getNombre());
		//pene.setVendido(8);
		//Paco.pinta(pene.getVendido());
		//pene.setVendido(1);
		//Paco.pinta(pene.getVendido());
		//pene.setMoneda("$");
		//Paco.pinta(pene.moneda);
		//pene.devolucion(5);
		//Paco.pinta(pene.getVendido());
		Articulo vagina=pene.clone();
		Paco.pinta(vagina.toString());
		Paco.pinta(pene.equals(vagina));
		vagina.setCoste(28);
		Paco.pinta(pene.equals(vagina));
		Paco.pinta(pene.hashCode()+"\n"+vagina.hashCode());
		Paco.pinta(pene.compareTo(vagina)+"\n"+vagina.compareTo(pene));
	}
}

