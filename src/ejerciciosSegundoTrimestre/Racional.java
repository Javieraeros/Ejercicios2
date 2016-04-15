package ejerciciosSegundoTrimestre;
/*
Racional
Propiedades:
Numerador, Entero, consultable y modificable.
Denominador, Entero distinto de cero, consultable y modificable.
Orden natural: el usual entre racionales.
Criterio de Igualdad: el usual entre racionales.
Representación como cadena: numerador y denominador separados por /. Si el denominador es 1 no aparecerá / ni el denominador.
Funcionalidades:
suma otro racional, devuelve void.
resta otro racional, devuelve el resultado de la resta.
multiplica otro racional, devuelve void.
divide otro racional, devuelve el resultado de la resta..
simplifica, devuelve void.
estáSimplificado, devuelve boolean.
valor, devuelve el valor real del racional.
 */

/* ***********
 * Propiedades
 * ***********
 * Basicas:
 * Numerador entero, consultable y modificable
 * Denominador entero, consultable y modificable
 * 
 * Derivadas:
 * valor real, consultable
 * 
 * Compartidas:
 *  
 * 
 * *************
 * Restricciones
 * *************
 * 
 * Denominador diferente de 0
 * 
 * ********
 * Interfaz
 * ********
 * Constructores:
 * Racional()
 * Racional(int numerador, int denominador)
 * 
 * Consultores:
 * int getNumerador()
 * int getDenominador()
 * double getValor()
 * 
 * Modificadores:
 * void setNumerador()
 * void setDenominador()
 * 
 * Métodos añadidos:
 * int[] MCD()
 * void suma(Racional sumar)
 * Racional resta(Racional restar)
 * void multiplica(Raciona multiplicar)
 * Racional divide(Racional dividir)
 * void simplifica()
 * boolean estaSimplificado()
 * 
 * 
 * *********************
 * Métodos Sobreescritos
 * *********************
 * boolean equals(Object o);
 * XXXXX clone();
 * String toString();
 * int hashCode();
 * ind compareTo(XXXX comparada);
 */

import java.lang.annotation.*;
public class Racional implements Comparable<Racional> {
	//atributos
	private int numerador;
	private int denominador;
	
	//constructores
	public Racional(){
		numerador=1;
		denominador=2;
	}
	public Racional(int numerador, int denominador)throws IllegalArgumentException{
		if (denominador==0){
			throw new IllegalArgumentException("El denominador no puede ser 0");
		}else{
			this.numerador=numerador;
			this.denominador=denominador;
		}
	}
	//consultores
	public int getNumerador(){
		return numerador;
	}
	
	public int getDenominador(){
		return denominador;
	}
	
	public double getValor(){
		return ((double) numerador/denominador);
	}
	
	//modificadores
	public void setNumerador(int numerador){
		this.numerador=numerador;
	}
	public void setDenominador(int denominador)throws IllegalArgumentException{
		if (denominador==0){
			throw new IllegalArgumentException("El denominador no puede ser 0");
		}else{
			this.denominador=denominador;
		}
	}
	//Métodos añadidos
	/* 
	 * Interfaz 
	 * Cabecera: void MCD(int[][] fracciones)
	 * Proceso: Calcula el minimo común denominador de dos fracciones
	 * Precondiciones:
	 * Entrada:nada
	 * Salida:nada
	 * Entrada/Salida:1 array de enteros
	 * Postcondiciones:Array asociada al nombre
	 */
	
	
	public void MCD(int[][] fracciones){
		int mcm=1;
        int conta=2;
        int denomina1=fracciones[1][0];
        int denomina2=fracciones[1][1];
        while(conta <= fracciones[1][0] || conta <= fracciones[1][1]){
            if(fracciones[1][0]%conta==0 || fracciones[1][1]%conta==0){
				mcm=mcm*conta;
				if(fracciones[1][0]%conta==0)
					fracciones[1][0]=fracciones[1][0]/conta;
				if(fracciones[1][1]%conta==0)
					fracciones[1][1]=fracciones[1][1]/conta;
            }
            else
                conta=conta+1;               
        }
        fracciones[1][0]=mcm;fracciones[1][1]=mcm;
        fracciones[0][0]=fracciones[0][0]*mcm/denomina1;
        fracciones[0][1]=fracciones[0][1]*mcm/denomina2;
	}
	/* 
	 * Interfaz 
	 * Cabecera: void suma(Racional sumar)
	 * Proceso: Suma un racional al objeto
	 * Precondiciones:Denominador diferente de 0
	 * Entrada:1 Racional
	 * Salida:Nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:Al objeto que llama al método se le suma el parámetro
	 */
	
	public void suma(Racional sumar){
		int[][] suma=new int[2][2];
		suma[0][0]=this.numerador;
		suma[1][0]=this.denominador;
		suma[0][1]=sumar.getNumerador();
		suma[1][1]=sumar.getDenominador();
		MCD(suma);
		this.numerador=suma[0][0]+suma[0][1];
		this.denominador=suma[1][0];
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: Racional resta(Racional restar)
	 * Proceso:Restamos un racional al objeto que llama al método PERO NO cambiamos este objeto
	 * Precondiciones:
	 * Entrada:1 Racional
	 * Salida:1 Racional
	 * Entrada/Salida:NAda
	 * Postcondiciones:Racional asociado al nombre
	 */
	 
	public Racional resta (Racional restar){
		int[][] arestar=new int[2][2];
		arestar[0][0]=this.numerador;
		arestar[1][0]=this.denominador;
		arestar[0][1]=restar.getNumerador();
		arestar[1][1]=restar.getDenominador();
		MCD(arestar);
		Racional diferencia=new Racional(0,arestar[1][1]);
		diferencia.setNumerador(arestar[0][0]-arestar[0][1]);
		return diferencia;
	}
	/* 
	 * Interfaz 
	 * Cabecera: void multiplica (Racional multiplicar)
	 * Proceso: Multiplicamos nuestro racional por otro pasado por parámetro
	 * Precondiciones:Denominador distinto de 0
	 * Entrada:! racional
	 * Salida:Nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:Cambia nuestor racional
	 */
	public void multiplica(Racional multiplicar){
		this.numerador=this.numerador*multiplicar.getNumerador();
		this.denominador=this.denominador*multiplicar.getDenominador();
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: Racional divide(Racional dividir)
	 * Proceso:Dividimos nuestro racional por uno dado, y lo devolvemos asociado al nombre
	 * Precondiciones:Denominadores distintos de 0
	 * Entrada:1 racional
	 * Salida:1 racional
	 * Entrada/Salida:Nada
	 * Postcondiciones:Nuestro Racional NO cambia
	 */
	public Racional divide(Racional dividir){
		Racional divide=new Racional();
		divide.setNumerador(this.numerador*dividir.getDenominador());
		divide.setDenominador(this.denominador*dividir.getNumerador());
		return divide;
	}
	
	/* 
	 * Interfaz 
	 * Cabecera:boolean estaSimplificado()
	 * Proceso: Nos devuelve si un racional está simplificado o no
	 * Precondiciones:Denominador distinto de 0
	 * Entrada:Nada
	 * Salida:1 booleano
	 * Entrada/Salida:Nada
	 * Postcondiciones:Booleano asociado al nombre, true si está simplificado, false en caso contrario
	 */
	public boolean estaSimplificado(){
		int conta,menor,mayor;
		boolean resul=true;
		if(this.numerador>=this.denominador){
			menor=this.denominador;
			mayor=this.numerador;
		}else{
			menor=this.numerador;
			mayor=this.denominador;
		}
		for(conta=2;conta<=menor;conta++){
			if(menor%conta==0 && mayor%conta==0){
				resul=false;
			}
		}
		return resul;
	}
	/* 
	 * Interfaz 
	 * Cabecera:void simplifica()
	 * Proceso:Simplifica un racional
	 * Precondiciones:Denominador distinto de 0,Racional no simplificado
	 * Entrada:Nada
	 * Salida:Nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:Ninguna
	 */
	public void simplifica()throws Excepciones{
		if(estaSimplificado()==true){
			throw new Excepciones("El racional ya esta simplificado");
		}else{
			int conta,menor,mayor;
			int i,j;
			//Vemos cual es el menor de los dos, si numerador o denominador
			if(this.numerador>=this.denominador){
				menor=this.denominador;
				mayor=this.numerador;
			}else{
				menor=this.numerador;
				mayor=this.denominador;
			}
			/*Creamos una matriz de booleanos con indices con significado.
			 * Toda ella a false */
			
			boolean[][] divisores=new boolean[2][menor+1]; 
			for(i=0;i<2;i++){
				for(j=0;j<divisores[0].length;j++){
					divisores[i][j]=false;
				}
			}
			/* En caso de que el menor de los dos sea divisible por el indice, guaradaremos true en la fila 0, false en caso contrario
			 * Si el mayor de los dos es divisible por el índice, guardaremos true en la fila 1 y en la columna con ese indice, false en caso contrario
			 */
			
			for(conta=2;conta<=divisores[0].length;conta++){
				if(menor%conta==0){
					divisores[0][conta]=true;
					menor=menor/conta;
				}
				if(mayor%conta==0){
					divisores[1][conta]=true;
					mayor=mayor/conta;
				}
			}
			for(j=2;j<divisores[0].length;j++){
				if (divisores[0][j]==true && divisores[1][j]==true){
					this.numerador=this.numerador/j;
					this.denominador=this.denominador/j;
				}
			}
		}
	}
	
	@Override
	public String toString(){
		String s;
		if (denominador==1){
			s=("("+numerador+")");
		}else{
			s=("("+numerador+"/"+denominador+")");
		}
		return s;
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
		if (o!=null && o instanceof Racional){
			Racional r=(Racional) o;
			if (r.getValor()==getValor())
				resultado=true;
		}
		return resultado;
	}	
	
	/* 
	 * Interfaz 
	 * Cabecera: int compareTo(Racional comparado)
	 * Proceso Método que compara si un dos racionales son IGUALES
	 * Precondiciones:Nada
	 * Entrada:1 racional
	 * Salida:1 Entero
	 * Entrada/Salida:Nada
	 * Postcondiciones:Devuelve 1 si el racional que usa el método es mayor que el racional que paso por parametro
	 * 0 si son iguales, -1 en caso contrario.
	 */
	@Override
	public int compareTo(Racional comparado){
		int resul=-1;
		if(getValor()>comparado.getValor()){
			resul=1;
		}else{
			if(getValor()==comparado.getValor())
				resul=0;
		}
		return resul;
	}
}

