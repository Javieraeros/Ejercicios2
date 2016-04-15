package ejerciciosSegundoTrimestre;
/*
 * Recta para representar rectas en el plano según la ecuación de la recta en forma implícita: ax+by+c=0, dónde a,b y c son 
 * los coeficientes de la recta.
 * Además de los clásicos, la clase tendrá un constructor que recibirá dos puntos como parámetros, 
 * que serán dos puntos sobre los que pasa la recta.
 * También tendrá, además de los elementales, un método para comprobar si una recta contiene un determinado punto pasado como parámetro.
 * Busca en Internet cualquier información que necesites
 * 
 * ***********
 * Propiedades
 * ***********
 * Basicas:
 * (coeficiente) a=real,consultable y modificable
 * (coeficiente) b=real,consultable y modificable
 * (coeficiente) c=real,consultable y modificable
 * 
 * 
 * Derivadas:
 * Pendiente=real y consultable
 * 
 * 
 * *************
 * Restricciones
 * *************
 * 
 * 
 * ********
 * Interfaz
 * ********
 * Constructores:
 * Recta()
 * Recta (double a,double b,double c)
 * Recta(punto p, punto p2)
 * 
 * Consultores:
 * double getA()
 * double getB()
 * double getC()
 * double getPendiente()
 * 
 * Modificadores:
 * void setA(double a)
 * void setB(double b)
 * void setC(double c)
 * 
 * Métodos añadidos:
 * boolean compruebaPunto(punto p)
 * 
 * 
 * *********************
 * Métodos Sobreescritos
 * *********************
 * boolean equals(Object o);
 * Recta clone();
 * String toString();
 * int hashCode();
 * ind compareTo(Recta comparada);
 * 
 */

import java.lang.Math;
public class Recta implements Cloneable,Comparable <Recta> {
	//Atributos
	private double a;
	private double b;
	private double c;
	//Constructores
	public Recta(){
		this.a=1;
		this.b=1;
		this.c=0;
	} 
	
	public Recta(double a,double b,double c)throws IllegalArgumentException{
		if (a==0 && b==0){
			IllegalArgumentException error=new IllegalArgumentException("Los coeficientes no pueden ser ambos 0");
			throw error;
		}
		else{
			this.a=a;
			this.b=b;
			this.c=c;
		}
	}
	public Recta(Punto p,Punto p2)throws IllegalArgumentException{
		if (p.equals(p2)){
			IllegalArgumentException error=new IllegalArgumentException("Error, has introducido el mismo punto dos veces");
			throw error;
		}
		else{
			this.a=p2.getY()-p.getY();
			this.b=-(p2.getX()-p.getX());
			this.c=p.getY()*(p2.getX()-p.getX())-p.getX()*(p2.getY()-p.getY());
		}
	}
	//Consultores
	public double getA(){
		return this.a;
	}
	public double getB(){
		return this.b;
	}
	public double getC(){
		return this.c;
	}
	public double getPendiente(){
		return Math.atan(-a/b)/Math.PI*180;
	}
	//Modificadores
	public void setA(double a) throws IllegalArgumentException{
		if (a==0 && this.b==0){
			IllegalArgumentException error=new IllegalArgumentException("Los coeficientes no pueden ser ambos 0");
			throw error;
		}
		else{
			this.a=a;
		}
	}
	public void setB(double b) throws IllegalArgumentException{
		if (this.a==0 && b==0){
			IllegalArgumentException error=new IllegalArgumentException("Los coeficientes no pueden ser ambos 0");
			throw error;
		}
		else{
			this.b=b;
		 }
	}
	public void setC(double c){
		this.c=c;
	}
	//Métodos Añadidos
	public boolean compruebaPunto (Punto p){
		boolean resul;
		if(a*p.getX()+b*p.getY()+c==0)
			resul=true;
		else
			resul=false;
		return resul;
	}
	/* 
	 * Interfaz 
	 * Cabecera: boolean equals(Object o)
	 * Proceso: Método que devuelve si un objeto es IGUAL a otro
	 * Precondiciones:Ninguna
	 * Entrada:1 objeto
	 * Salida: 1 booleano
	 * Entrada/Salida:Nada
	 * Postcondiciones:Booleano asociado al nombre, true si los objetos son iguales, false en caso contrario
	 */
	@Override
	public boolean equals(Object o){
		boolean resultado=false;
		if(o!=null && o instanceof Recta){
			Recta r=(Recta) o;
			if (this.a==r.getA() && this.b==r.getB() && this.c==r.getC())
				resultado=true;
		}
		return resultado;
	}
	@Override
	public Recta clone(){
		Recta clonado=new Recta();
		try{
			clonado=(Recta) super.clone();
		}catch (CloneNotSupportedException error){
		System.out.println("Objeto no clonado");
		}
		return clonado;
	}
	@Override
	public String toString(){
		return ("A: "+a+" B: "+b+" C: "+c);
	}
	@Override
	public int hashCode(){
		return ((int) (this.getPendiente()*31+a+b));
	}
	
	/*
	 * Interfaz 
	 * Cabecera: int compareTo(Recta comparada)
	 * Proceso Método que compara si un dos Rectas son IGUALES
	 * Precondiciones:Nada
	 * Entrada:1 Fecha
	 * Salida:1 Entero
	 * Entrada/Salida:Nada
	 * Postcondiciones:Devuelve 1 si la recta que usa el método tiene una pendiente mayor que con la que se compara,
	 * 0 si ambas pendientes son iguales y -1 si la pendiente es menor
	 */
	@Override
	public int compareTo(Recta comparada){
		int resultado;
			if(this.getPendiente()>comparada.getPendiente())
				resultado=1;
			else{
				if (this.getPendiente()==comparada.getPendiente())
					resultado=0;
				else
					resultado=-1;
			}
		return (resultado);
		
	}
}

