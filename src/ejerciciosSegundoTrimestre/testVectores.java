package ejerciciosSegundoTrimestre;
public class testVectores {
	
	public static void main (String args[]) {
		Vector v=new Vector();
		Vector v2=new Vector(-0,-0,0);
		Vector v3=new Vector(-5.3,2.4,-9.8);
		Paco.pinta(v3.getX());
		Paco.pinta(v3.getModulo());
		Paco.pinta(v2.getTheta());
		Paco.pinta(v3.getPhi());
	}
}

