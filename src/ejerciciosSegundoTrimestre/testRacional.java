package ejerciciosSegundoTrimestre;
public class testRacional {
	
	public static void main (String args[]) {
		Racional Javi=new Racional(144,360);
		Racional Pene=new Racional(2,5);
		//Javi.suma(Pene);
		//Paco.pinta(Javi.getNumerador()+" "+Javi.getDenominador());
		//Racional Resta=Javi.resta(Pene);
		//Paco.pinta(Resta.getNumerador()+" "+Resta.getDenominador());
		/*Paco.pinta(Javi.estaSimplificado()+" "+Pene.estaSimplificado());
		try{
			Javi.simplifica();
		}catch(Excepciones error){
			Paco.pinta(error);
		}
		Paco.pinta(Javi.getNumerador()+"\n"+Javi.getDenominador());
		Paco.pinta(Pene.getValor());
		Paco.pinta(Pene.toString());
		Paco.pinta(Javi.equals(Pene));*/
		Paco.pinta(Javi.compareTo(Pene));
	}
}

