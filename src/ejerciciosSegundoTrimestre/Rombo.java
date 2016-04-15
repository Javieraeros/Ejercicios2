package ejerciciosSegundoTrimestre;
/*
 * ***********
 * Propiedades
 * ***********
 * Basicas:
 * Diagonal A real, consultable y modificable
 * Diagonal B real,consultable y modificable 
 *
 * Derivadas:
 * Lado real,consultable
 * Area real, consultable
 * Perimetro real,consultable
 * 
 * Compartidas:
 * 
 * 
 * *************
 * Restricciones
 * *************
 * Diagonales ambas mayores a 0
 * 
 * ********
 * Interfaz
 * ********
 * Constructores:
 * Rombo()
 * Rombo(double diaMayor,double diaMenor)
 * 
 * Consultores:
 * double getDiagonalMayor()
 * double getDiagonalMenor()
 * double getLado()
 * double getArea()
 * double getPerimetro()
 * 
 * Modificadores:
 * void setDiagonalMayor(double diagonal)
 * void setDiagonalMenor(double diagonal)
 * 
 * Métodos añadidos:
 * 
 * 
 * 
 * *********************
 * Métodos Sobreescritos
 * *********************
 * boolean equals(Object o);
 * Rombo clone();
 * String toString();
 * int hashCode();
 * ind compareTo(Rombo comparado);
 
 */

import java.lang.annotation.*;
public class Rombo implements Cloneable,Comparable <Rombo> {
	//atributos
	private double diagonalA;
	private double diagonalB;
	
	//Constructores
	public Rombo(){
		this.diagonalA=1;
		this.diagonalB=1;
	}
	public Rombo(double diaMayor,double diaMenor)throws IllegalArgumentException{
		if(diaMayor<=0 || diaMenor<=0){
			IllegalArgumentException error=new IllegalArgumentException("Ninguna diagonal puede ser 0 o menor");
			throw error;
		}
		else{
			this.diagonalA=diaMayor;
			this.diagonalB=diaMenor;
		}
	}
	//Consultores
	public double getDiagonalA(){
		return diagonalA;
	}
	
	public double getDiagonalB(){
		return diagonalB;
	}
	
	public double getLado(){
		return (0.5*Math.sqrt(diagonalA*diagonalA+diagonalB*diagonalB));
	}
	public double getArea(){
		return (diagonalA*diagonalB/2);
	}
	public double getPerimetro(){
		return (2*Math.sqrt(diagonalA*diagonalA+diagonalB*diagonalB));
	}
	//Modificadores
	public void setDiagonalA(double diaMayor) throws IllegalArgumentException{
		if (diaMayor<=0){
			IllegalArgumentException error=new IllegalArgumentException("La diagonal Mayor no puede ser 0");
			throw error;
		}else{
			this.diagonalA=diaMayor;
		}
	}
	public void setDiagonalB(double diaMenor) throws IllegalArgumentException{
		if (diaMenor<=0){
			IllegalArgumentException error=new IllegalArgumentException("La diagonal Mayor no puede ser 0");
			throw error;
		}else{
			this.diagonalB=diaMenor;
		}
	}
	//Metodos sobrescritos
	
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
		boolean resul=false;
		if(o!=null && o instanceof Rombo){
			Rombo r=(Rombo) o;
			if (diagonalA==r.getDiagonalA() && diagonalB==r.getDiagonalB())
				resul=true;
		}
		return resul;
	}
	
	@Override
	public Rombo clone(){
		Rombo clonado=null;
		try{
			clonado=(Rombo) super.clone();
		}catch(CloneNotSupportedException error){
			System.out.println("No se puede cloanr el Rombo");
		}
		return clonado;
	}
	
	@Override
	public String toString(){
		return ("Diagonal A: "+diagonalA+" Diagonal B: "+diagonalB);
	}
	@Override
	public int hashCode(){
		return ((int) (getLado()*31+getPerimetro()*101+getArea()*17));
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: int compareTo(Rombo comparada)
	 * Proceso Método que compara si un dos Rombos son IGUALES
	 * Precondiciones:Nada
	 * Entrada:1 Fecha
	 * Salida:1 Entero
	 * Entrada/Salida:Nada
	 * Postcondiciones:Devuelve 1 si el rombo que usa el método tiene mayor area que el otro rombo, 0 si son iguales las áreas
	 *  y -1 en caso contrario.
	 */
	 
	@Override
	public int compareTo(Rombo comparado){
		int resul;
		if(this.getArea()>comparado.getArea())
			resul=1;
		else{
			if (this.getArea()==comparado.getArea())
				resul=0;
			else
				resul=-1;
		}
		return resul;
	}
}

