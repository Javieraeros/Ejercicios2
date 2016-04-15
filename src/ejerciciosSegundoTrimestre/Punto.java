package ejerciciosSegundoTrimestre;
/*
 * ***********
 * Propiedades
 * ***********
 * Básicas:
 * X: Double, consultable y modificable
 * Y: Double, consultable y modificable
 * 
 * Derivadas:
 * DistanciaAlOrigen: Double, consultable
 * DistanciaAOtroPunto(Punto p):Double, consultable
 * 
 * Compartidas:
 * Origen: Punto, Consultable, compartida 
 * 
 * ********
 * Interfaz
 * ********
 * Consultores:
 * double getX()
 * double getY()
 * Punto getOrigen()
 * 
 * Modificadores:
 * void setX(Double x1)
 * void setY(Double y1)
 * 
 * Otras Funcionalidades:
 * double DistanciaAlOrigen();
 * double DistanciaAOtroPunto(Punto p);
 * 
 * *********************
 * Métodos Sobreescritos
 * *********************
 * 
 * boolean equals(Objetc o)
 * Punto clone()
 * String toString()
 * int hashCode()
 * int comparteTo(CPunto pto)
 */

import java.lang.annotation.*;
public class Punto implements Cloneable,Comparable<Punto> {
	//Atributos
	private double x;
	private double y;
	private static Punto origen=new Punto(0.0,0.0);
	
	//Constructores por defecto
	public Punto(){
		x=0.0;
		y=0.0;
	}
	//No suele usarse, solo a modo de ejemplo
	public Punto(double x){
		this.x=x;
		y=0.0;
	}
	public Punto(double x,double y){
		this.x=x;
		this.y=y;
	}

	//Modificadores o consultores
	public double getX(){
		return(x);
	}
	public double getY(){
		return(y);
	}
	public Punto getOrigen(){
		return(origen);
	}
	public void setX(double x){
		this.x=x;
	}
	public void setY(double y){
		this.y=y;
	}
	//Métodos añadidos
	public double DistanciaAlOrigen(){
		return(Math.sqrt((x-origen.getX())*(x-origen.getX())+(y-origen.getY())*(y-origen.getY())));
	}
	public double DistanciaAOtroPunto(Punto p){
		double x=p.getX();
		double y=p.getY();
		return(Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y)));
	}
	
	
	//Métodos heredados
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
		boolean resultado;
		resultado=false;
		if (o!=null && o instanceof Punto){
			Punto pto=(Punto) o;
			if (x==pto.x && y==pto.y)
				resultado=true;
		}
		return resultado;
	}
	@Override
	public String toString(){
		String s="("+x+","+y+")";
		return s;
	}
	@Override
	public int hashCode(){
		final int numPrimo = 31;
		double z=(31*(x*x+y*y)*x*y+(x*x+y*y)/x/y);
		return (int) z;
	}
	@Override
	public Punto clone(){
		Punto clonado=null;
		try{
			clonado=(Punto) super.clone();
		}catch (CloneNotSupportedException error){
		System.out.println("Objeto no clonado");
		}
		return clonado;
	}
	//Hacer Interfaz
	/* 
	 * Interfaz 
	 * Cabecera: int compareTo(Punto pto)
	 * Proceso Métoddo que compara si un dos puntos son IGUALES
	 * Precondiciones:Nada
	 * Entrada:1 Punto
	 * Salida:1 Entero
	 * Entrada/Salida:Nada
	 * Postcondiciones:Devuelve 1 si el punto que usa el método es mayor que el punto que paso por parametro
	 * 0 si son iguales, -1 en caso contrario.La comparación se hace con la distancia al origen
	 */
	@Override
	public int compareTo(Punto pto){
		int resultado;
		if (this.x*this.x+this.y*this.y>=pto.x*pto.x+pto.y*pto.y){
			if (this.x*this.x+this.y*this.y>pto.x*pto.x+pto.y*pto.y){
				resultado=1;
			}
			else{
				resultado=0;
			}
		}
		else{
			resultado=-1;
		}
		return resultado;
	}
}

