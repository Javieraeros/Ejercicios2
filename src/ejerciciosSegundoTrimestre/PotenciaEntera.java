package ejerciciosSegundoTrimestre;
/*
PotenciaEntera
Propiedades:
Base, Entero positivo, consultable y modificable.
Exponente, Entero positivo, consultable y modificable.
Orden natural: por el valor que tenga.
Criterio de Igualdad: si tienen la misma base y el mismo exponente.
Representación como cadena: base y exponente separados por comas entre paréntesis.
Funcionalidades:
Valor, devuelve un entero que es su valor entero.
 */

/* ***********
 * Propiedades
 * ***********
 * Basicas:
 * Base entero,consultable y modificable
 * Exponente entero, consultable y modificable
 * 
 * *************
 * Restricciones
 * *************
 * Base y exponente mayor que 0
 * 
 * ********
 * Interfaz
 * ********
 * Constructores:
 * PotenciaEntera()
 * POtenciaEntera(int base,int exponente)
 * 
 * Consultores:
 * int getBase()
 * int getExponente()
 * 
 * Modificadores:
 * void setBase(int base)
 * void setExponente (int exponente)
 * 
 * Métodos añadidos:
 * 
 * int valor()
 * 
 * *********************
 * Métodos Sobreescritos
 * *********************
 * boolean equals(Object o);
 * String toString();
 * ind compareTo(XXXX comparada);
*/

import java.lang.annotation.*;
public class PotenciaEntera implements Comparable<PotenciaEntera> {
	//atributos
	private int base;
	private int exponente;
	
	//constructores
	public PotenciaEntera(){
		base=1;
		exponente=0;
	}
	public PotenciaEntera(int base,int exponente)throws IllegalArgumentException{
		if (base==0 && exponente==0 || base<0 || exponente<0){
			throw new IllegalArgumentException("El exponente y/o la base no pueden ser 0");
		}else{
			this.base=base;
			this.exponente=exponente;
		}
	}
	//consultores
	public int getBase(){
		return base;
	}
	public int getExponente(){
		return exponente;
	}
	//modificadores
	public void setBase(int base)throws IllegalArgumentException{
		if (exponente==0 && base==0 || base<0){
			throw new IllegalArgumentException("Exponente y base no pueden ser 0, o menor");
		}else{
			this.base=base;
		}
	}
	public void setExponente(int exponente)throws IllegalArgumentException{
		if (exponente==0 && base==0 || exponente<0){
			throw new IllegalArgumentException("Exponente y base no pueden ser 0, o menor");
		}else{
			this.exponente=exponente;
		}
	}
	//metodos añadidos
	/* 
	 * Interfaz 
	 * Cabecera: int valor()
	 * Proceso: devuelve el valor de la potencia entera
	 * Precondiciones:ninguna
	 * Entrada:nada
	 * Salida:1 entero
	 * Entrada/Salida:nada
	 * Postcondiciones:valor asociado al nombre
	 */
	public int valor(){
		int valor=1;
		if (exponente!=0 && base!=0){
			for (int conta=1;conta<=exponente;conta++){
				valor=base*valor;
			}
		}else{
			if (base==0){
				valor=0;
			}
		}
		return valor;
	}
	
	@Override
	public String toString(){
		return ("("+base+","+exponente+")");
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
		boolean resultado;
		resultado=false;
		if (o!=null && o instanceof PotenciaEntera){
			PotenciaEntera potEnt=(PotenciaEntera) o;
			if (base==potEnt.getBase() && exponente==potEnt.getExponente())
				resultado=true;
		}
		return resultado;
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: int compareTo(Potenciaentera comparada)
	 * Proceso Método que compara si dos Potencias enteras son IGUALES
	 * Precondiciones:Nada
	 * Entrada:1 Potencia entera
	 * Salida:1 Entero
	 * Entrada/Salida:Nada
	 * Postcondiciones:Devuelve 1 si la potencai entera que usa el método es mayor que la potencia entera que paso por parametro
	 * 0 si son iguales, -1 en caso contrario. Utilizaremos el valor para compararlas
	 */
	@Override
	public int compareTo(PotenciaEntera comparada){
		int resul=-1;
		if (valor()>comparada.valor()){
			resul=1;
		}else{
			if(valor()==comparada.valor()){
				resul=0;
			}
		}
		return resul;
	}
}

