package ejerciciosSegundoTrimestre;

public class testPotencia {
	
	public static void main (String args[]) {
		PotenciaEntera pe=new PotenciaEntera(5,3);
		Paco.pinta(pe.getBase());
		//pe.setBase(0);
		pe.setExponente(0);
		Paco.pinta(pe.valor());
	}
}

