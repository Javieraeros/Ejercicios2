package ejerciciosSegundoTrimestre;
public class testRombo {
	
	public static void main (String args[]) {
		
		Rombo mir=new Rombo(1.41421356237,1.41421356237);
		
		//Paco.pinta(mir.getLado());
		//Paco.pinta(mir.getArea());
		//Paco.pinta(mir.getPerimetro());
		//mir.setDiagonalA(0);
		Rombo tur=mir.clone();
		//Paco.pinta(mir.equals(tur));
		//tur.setDiagonalA(4.3);
		//Paco.pinta(mir.equals(tur));
		Paco.pinta(tur.toString());
		Paco.pinta(tur.compareTo(mir));
	}
}

