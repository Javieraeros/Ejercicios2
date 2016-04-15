package ejerciciosSegundoTrimestre;
/*
 * Circulo.java
 * ***********
 * Propiedades
 * ***********
 * Basicas:
 * centro:Punto,consultable y modificable
 * radio:double,cpnsultable y modificable
 * 
 * Derivadas:
 * area:double,consultable
 * longitudcircun:double,consultable
 * 
 * Compartidas:
 * pi:double,consultable
 * 
 * *************
 * Restricciones
 * *************
 * radio>0
 * area=pi*radio*radio
 * longitud=2*pi*radio
 * 
 * ********
 * Interfaz
 * ********
 * Constructores:
 * Circulo()
 * Circulo(Punto centro, double radio)
 * 
 * Consultores:
 * double getCentroX();
 * double getCentroY();
 * double getRadio();
 * double getArea();
 * double getLongitudCircun();
 * double getPi();
 * 
 * 
 * Modificadores:
 * void setCentroX(double x);
 * void setCentroY(double y);
 * void setRadio(double radio);
 * 
 * *********************
 * Métodos Sobreescritos
 * *********************
 * 
 * boolean equals(Objetc o)
 * Circulo clone()
 * String toString()
 * int hashCode()
 * int comparteTo(Circulo c)
 * 
 */

import java.lang.annotation.*;
public class Circulo implements Cloneable,Comparable <Circulo> {
	//atributos
	private double radio;
	private Punto centro;
	private static final double pi=3.1415;
	//Cosntructores
	public Circulo (){
		radio=1.0;
		Punto centro=new Punto();
	}
	public Circulo(Punto centro,double radio){
		this.radio=radio;
		this.centro=centro;
	}
	//Consultores
	public double getCentroX(){
		return centro.getX();
	}
	public double getCentroY(){
		return centro.getY();
	}
	public double getRadio(){
		return radio;
	}
	public double getArea(){
		return (pi*radio*radio);
	}
	public double getLongitudCircun(){
		return (2*pi*radio);
	}
	public double getPi(){
		return pi;
	}
	//Modificadores
	public void setCentroX(double x){
		centro.setX(x);
	}
	public void setCentroY(double y){
		centro.setY(y);
	}
	public void setRadio(double radio){
		this.radio=radio;
	}
	//Métodos Sobreescritos
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
		if (o!=null && o instanceof Circulo){
			Circulo c=(Circulo) o;
			if (this.radio==c.radio && this.centro.equals(c.centro)==true)
				resultado=true;
		}
		return resultado;
	}
	@Override
	public Circulo clone(){
		Circulo clonado=null;
		try{
			clonado=(Circulo) super.clone();
			clonado.centro=centro.clone();
		}catch (CloneNotSupportedException error){
		System.out.println("Objeto no clonado");
		}
		return clonado;
	}
	@Override
	public int hashCode(){
		return (int) (centro.getX()*centro.getY()/radio*97);
	}
	@Override
	public String toString (){
		String s="";
		s=("(["+centro.getX()+","+centro.getY()+"]"+","+radio+")");
		return s;
	}
	/* 
	 * Interfaz 
	 * Cabecera: int compareTo(Circulo cir)
	 * Proceso Métoddo que compara si un dos circulos son IGUALES
	 * Precondiciones:Nada
	 * Entrada:1 Circulo
	 * Salida:1 Entero
	 * Entrada/Salida:Nada
	 * Postcondiciones:Devuelve 1 si el circulo que usa el método es mayor que el circulo que paso por parametro
	 * 0 si son iguales, -1 en caso contrario.Dos circulos son iguales cuando tienen el mismo radio.
	 */
	@Override
	public int compareTo(Circulo cir){
		int resultado;
		if(this.radio>=cir.radio){
			if(this.radio==cir.radio){
				resultado=0;
			}
			else{
				resultado=1;
			}
		}
		else{
			resultado=-1;
		}
		return resultado;
	}
}

