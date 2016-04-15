package ejerciciosSegundoTrimestre;
/* ***********
 * Propiedades
 * ***********
 * Basicas:
 * Coordenada X:Real, consultable y modificable
 * Coordenada Y:Real,consultable y modificable
 * Coordenada Z:Real,consultable y modificable
 * 
 * Derivadas:
 * Modulo:Real y consultable
 * Angulo theta:Real y consultable
 * Angulo Phi:REal y consultable
 * 
 * Compartidas:
 * Pi:Real y consultable 
 * 
 * *************
 * Restricciones
 * *************
 * X,y o z alguna diferente de 0
 * 
 * ********
 * Interfaz
 * ********
 * Constructores:
 * Vector();
 * Vector(double x,double y,double x);
 * 
 * Consultores:
 * double getX();
 * double getY();
 * double getZ();
 * double getModulo();
 * double getTheta();
 * double getPhi();
 * 
 * Modificadores:
 * void setX(double x);
 * void setY(double y);
 * void setZ(double z);
 * 
 * *********************
 * Métodos Sobreescritos
 * *********************
 * boolean equals(Object o);
 * Vector clone();
 * String toString();
 * int hashCode();
 * ind compareTo(Vector comparado);
 */
import java.lang.annotation.*;
public class Vector {
	//atributos
	private double x;
	private double y;
	private double z;
	public final double pi=Math.PI;
	
	//constructores
	public Vector(){
		x=1;
		y=1;
		z=1;
	}
	
	public Vector(double x,double y,double z)throws IllegalArgumentException{
		if(x!=0 || y!=0 || z!=0){
			this.x=x;
			this.y=y;
			this.z=z;
		}else{
			throw new IllegalArgumentException("Error, alguna coordenada tiene que ser diferente de 0");
		}
	}
	
	//consultores
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public double getZ(){
		return this.z;
	}
	
	public double getModulo(){
		return (Math.sqrt(x*x+y*y+z*z));
	}
	
	public double getTheta(){
		double theta;
		if (z==0){
			theta=pi/2;
		}else{
			theta=Math.atan(Math.sqrt(x*x+y*y)/z);
			if (z<0)
				theta=pi+theta;
		}
		return (theta*180/pi);
	}
	
	public double getPhi(){
		double phi;
		if(x==0){
			phi=Math.abs(y)/y*pi/2;
		}else{
			phi=Math.atan(y/x);
		}
		return (phi*180/pi);
	}
	
	//modificadores
	public void setX(double x)throws IllegalArgumentException{
		if(this.y==0 && this.z==0 && x==0){
			throw new IllegalArgumentException("Error, todos los elementos no pueden ser 0");
		}else{
			this.x=x;
		}
	}
	public void setY(double y)throws IllegalArgumentException{
		if(this.x==0 && this.z==0 && y==0){
			throw new IllegalArgumentException("Error, todos los elementos no pueden ser 0");
		}else{
			this.y=y;
		}
	}
	public void setZ(double z)throws IllegalArgumentException{
		if(this.x==0 && this.y==0 && z==0){
			throw new IllegalArgumentException("Error, todos los elementos no pueden ser 0");
		}else{
			this.z=z;
		}
	}
	
	
}

