package ejerciciosSegundoTrimestre;
/*Círculo
Propiedades:
Centro: Punto, consultable y modificable.
Radio: real, consultable y modificable.
Orden natural: por el centro y a igualdad de éste por el radio.
Criterio de Igualdad: si tienen el mismo centro y el mismo radio.
Representación como cadena: Centro y Radio separados por comas y entre paréntesis.
Funcionalidades:
Desplazar: desplaza el centro pero conserva el radio.
Restricciones:
centro no puede ser null
radio no puede ser menor o igual a cero.
Consideraciones:
Estamos interesados en saber el área y el perímetro.
 */
 
/* ***********
 * Propiedades
 * ***********
 * Basicas:
 * Centro: Punto, consultable y modificable.
 * Radio: real, consultable y modificable.
 * 
 * Derivadas:
 * area: Real, consultable
 * perimetor: Real y consultable
 * 
 * Compartidas:
 * Pi:Real y consultable
 * 
 * *************
 * Restricciones
 * *************
 * Centro no puede ser null
 * Radio no puede ser menor o igual a 0
 * 
 * ********
 * Interfaz
 * ********
 * Constructores:
 * Circulito();
 * Circulito(Punto centro,double radio)
 * 
 * Consultores:
 * double getCentroX();
 * double getCentroY();
 * double getRadio();
 * double getArea();
 * double getPerimetro();
 * 
 * Modificadores:
 * void setCentro(Punto centro);
 * void setCentroX(double centrox);
 * void setCentroY(double centroy);
 * void setRadio(double radio)
 * 
 * Métodos añadidos:
 * 
 * void desplaza(Punto desplaza);
 * 
 * *********************
 * Métodos Sobreescritos
 * *********************
 * boolean equals(Object o);
 * Circulito clone();
 * String toString();
 * int hashCode();
 * ind compareTo(Circulito comparado);
 */
 
import java.lang.annotation.*;
public class Circulito implements Comparable <Circulito> {
	//atributos
	private Punto centro;
	private double radio;
	public static final double pi=3.14159;
	
	//constructores
	public Circulito(){
		Punto centro=new Punto(0,0);
		radio=1;
	}
	
	public Circulito(Punto centro,double radio)throws IllegalArgumentException{
		if (centro==null || radio<=0){
			if (centro==null){
				IllegalArgumentException centroError=new IllegalArgumentException ("Error, el centro no puede ser nulo");
				throw centroError;
			}else{
				IllegalArgumentException radioError=new IllegalArgumentException ("Error, el radio no puede ser 0 o menor");
				throw radioError;
			}
		}else{
			this.centro=centro;
			this.radio=radio;
		}
	}
	//Consultores
	public double getCentroX(){
		return centro.getX();
	}
	public double getCentroY(){
		return centro.getY();
	}
	public Punto getCentro(){
		return centro;
	}
	public double getRadio(){
		return radio;
	}
	public double getArea(){
		return pi*radio*radio;
	}
	public double getPerimetro(){
		return 2*pi*radio;
	}
	//Modificadores
	public void setCentro(Punto centro)throws IllegalArgumentException{
		if (centro==null){
			IllegalArgumentException centroError=new IllegalArgumentException ("Error, el centro no puede ser nulo");
			throw centroError;
		}else{
			this.centro=centro;
		}
	}
	
	public void setCentroX(double centroX){
		centro.setX(centroX);
	}
	
	public void setCentroY(double centroY){
		centro.setY(centroY);
	}
	
	public void setRadio(double radio)throws IllegalArgumentException{
		if (radio<=0){
			IllegalArgumentException radioError=new IllegalArgumentException("el radio no puede ser 0 o menor");
			throw radioError;
		}else{
			this.radio=radio;
		}
	}
	/* 
	 * Interfaz 
	 * Cabecera: void desplaza(Punto desplaza)
	 * Proceso: Desplaza el centro de un circulo
	 * Precondiciones: Desplazamiento no nulo
	 * Entrada:Un punto
	 * Salida:Nada
	 * Entrada/Salida: Nada
	 * Postcondiciones:Ninguna
	 */
	public void desplaza(Punto desplaza)throws IllegalArgumentException{
		if (desplaza==null){
			IllegalArgumentException error=new IllegalArgumentException("El punto no puede ser nulo");
			throw error;
		}else{
			centro.setX(desplaza.getX());
			centro.setY(desplaza.getY());
		}
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
		boolean resul=false;
		if (o!=null && o instanceof Circulito){
			Circulito c=(Circulito) o;
			if (this.centro.equals(c.getCentro())==true && radio==c.getRadio()){
				resul=true;
			}
		}
		return resul;
	}
	
	@Override
	public String toString(){
		return ("("+centro.getX()+","+centro.getY()+","+radio+")");
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
	 * 0 si son iguales, -1 en caso contrario.Se comparará primero por el centro, y después por el radio
	 */
	
	@Override
	public int compareTo(Circulito c){
		int resul;
		resul=centro.compareTo(c.getCentro());
		if (resul==0 && radio>c.getRadio()){
			resul=1;
		}else{
			if (resul==0 && radio<c.getRadio())
				resul=-1;
		}
		return resul;
	}
}

