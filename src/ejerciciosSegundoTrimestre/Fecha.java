package ejerciciosSegundoTrimestre;
/*
 * ***********
 * Propiedades
 * ***********
 * Basicas:
 * dia=Integer,consultable y modificable
 * mes=Integer,consultable y modificable
 * Anyo=Integer,consultable y modificable
 * 
 * *************
 * Restricciones
 * *************
 * Fecha v·lida, es decir, dia congruente con el mes y el aÒo
 * 
 * ********
 * Interfaz
 * ********
 * Constructores:
 * Fecha()
 * Fecha(int dia,int mes,int anyo)
 * 
 * Consultores:
 * int getDia()
 * int getMes()
 * int getAnyo()
 * 
 * Modificadores:
 * void setDia(int dia);
 * void setMes(int mes);
 * void setAnyo(int anyo);
 *
 * M√©todos a√±adidos:
 * boolean bisiesto();
 * Fecha fechaAnterior();
 * Fecha fechaPosterior();
 * boolean fechaValida(int dia,int mes,int anyo);
 * 
 * 
 * *********************
 * M√©todos Sobreescritos
 * *********************
 * boolean equals(Object o);
 * Fecha clone();
 * String toString();
 * int hashCode();
 * int compareTo(Fecha comparada);
 * 
 */
import java.lang.annotation.*;
public class Fecha implements Cloneable,Comparable<Fecha> {
	//Atributos
	private int dia;
	private int mes;
	private int anyo;
	//Constructores
	public Fecha(){
		dia=15;
		mes=10;
		anyo=1582;
	}
	public Fecha(int dia,int mes,int anyo) throws IllegalArgumentException{
		if(fechaValida(dia,mes,anyo)==false){
			IllegalArgumentException error=new IllegalArgumentException ("Fecha no valida");
			throw error;
		   }
		else{
			this.dia=dia;
			this.mes=mes;
			this.anyo=anyo;
		}
	}
	//Consultores
	public int getDia(){
		return this.dia;
	}
	public int getMes(){
		return this.mes;
	}
	public int getAnyo(){
		return this.anyo;
	}
	//Modificadores
	public void setDia(int dia) throws IllegalArgumentException{
		if(fechaValida(dia,mes,anyo)==false){
			IllegalArgumentException error=new IllegalArgumentException ("Fecha no valida. No ha sido modificada");
			throw error;
		}
		else
			this.dia=dia;
	}
	public void setMes(int mes) throws IllegalArgumentException{
		if(fechaValida(dia,mes,anyo)==false){
			IllegalArgumentException error=new IllegalArgumentException ("Fecha no valida. No ha sido modificada");
			throw error;
		}
		else
			this.mes=mes;
	}
	public void setAnyo(int anyo) throws IllegalArgumentException{
		if(fechaValida(dia,mes,anyo)==false){
			IllegalArgumentException error=new IllegalArgumentException ("Fecha no valida. No ha sido modificada");
			throw error;
		}
		else
			this.anyo=anyo;
	}
	//MÈtodos AÒadidos
	public Fecha fechaAnterior(){
		int diaAnterior=this.dia-1;
		int mesAnterior=this.mes;
		int anyoAnterior=this.anyo;
		if (diaAnterior<1){
			mesAnterior=mes-1;
			if (mesAnterior<1){
				anyoAnterior=anyo-1;
				mesAnterior=12;
			}
			switch (mesAnterior){
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					diaAnterior=31;
				break;
				case 4:
				case 6:
				case 9:
				case 11:
					diaAnterior=30;
				break;
				case 2:
					if(bisiesto()==true)
						diaAnterior=29;
					else
						diaAnterior=28;
				break;
			}
		}
		Fecha anterior=new Fecha(diaAnterior,mesAnterior,anyoAnterior);
		return anterior;
	}
	public Fecha fechaPosterior(){
		int diaPosterior;
		int mesPosterior=mes;
		int anyoPosterior=anyo;
		diaPosterior=dia+1;
		if (diaPosterior>31 || 
		   ((mesPosterior==4 || mesPosterior==6 || mesPosterior==9 || mesPosterior==11) && diaPosterior>30) || 
		   (diaPosterior>28 && mesPosterior==2 && bisiesto()==false) || 
		   (diaPosterior>29 && mesPosterior==2)){
			mesPosterior=mesPosterior+1;
			diaPosterior=1;
			if (mesPosterior>12){
				anyoPosterior=anyo+1;
				mesPosterior=1;
			}
		}
		Fecha posterior=new Fecha(diaPosterior,mesPosterior,anyoPosterior);
		return posterior;
	}
		public boolean bisiesto(){
		boolean bisiesto=false;
		if(anyo%4==0 && (anyo%100!=0 || anyo%400==0))
			bisiesto=true;
		return bisiesto;
	}
	/* 
	 * Interfaz 
	 * Cabecera: boolean fechaValida (int dia,int mes,int anyo)
	 * Proceso: M√©todo que devuelve si una fecha es v√°lida
	 * Precondiciones:Ninguna
	 * Entrada:3 enteros
	 * Salida: 1 booleano
	 * Entrada/Salida:Nada
	 * Postcondiciones:Booleano asociado al nombre, true si la fecha es v√°lida, false caso contrario
	 */
	public boolean fechaValida (int dia,int mes,int anyo){
		boolean resultado;
		if(anyo<1582 || (anyo==1582 && mes<10 || mes==10 && dia<15) ||
		 mes<1 || mes>12 || dia<1 || dia>31 || 
		(dia>30 && (mes==4 || mes== 6 || mes==9 || mes==11)) ||
		(dia>28 && mes==2 && bisiesto()==false) || 
		(dia>29 && mes==2))
			resultado=false;
		else
			resultado=true;
		return resultado;
		  
	}
	
	
	/* 
	 * Interfaz 
	 * Cabecera: int diasTranscurridos (Fecha contar)
	 * Proceso MÈtodo que comprueba los dÌas transcurridos entre dos fechas
	 * Precondiciones:Ninguna
	 * Entrada:1 Fecha
	 * Salida:1 entero
	 * Entrada/Salida:Nada
	 * Postcondiciones:Salida asociada al nombre,se tendr· en cuenta los aÒos bisiestos, devolver· -1 si las fechas no son validas
	 */
	//resguardo
	/*public int diasTranscurridos (Fecha contar){
		return(0);
	}*/
	
	public int diasTranscurridos (Fecha contar){
		int resultado=0;
		Fecha aux=contar.clone();
		if(fechaValida(contar.getDia(),contar.getMes(),contar.getAnyo())==true){
			
				
			while(contar.getDia()!=dia || contar.getMes()!=mes || contar.getAnyo()!=anyo){
				if (this.compareTo(contar)==-1){
					aux.fechaAnterior();
				}else{
					aux.fechaPosterior();
				}
			}
			resultado=resultado+1;
		}
		else
			resultado=-1;
		return(resultado);
	}
	
	
	/* 
	 * Interfaz 
	 * Cabecera: boolean equals(Object o)
	 * Proceso: M√©todo que devuelve si un objeto es IGUAL a otro
	 * Precondiciones:Ninguna
	 * Entrada:1 objeto
	 * Salida: 1 booleano
	 * Entrada/Salida:Nada
	 * Postcondiciones:Booleano asociado al nombre, true si los objetos son iguales, false en caso contrario
	 */
	 @Override
	public boolean equals(Object o){
		boolean resultado=false;
		if(o!=null && o instanceof Fecha){
			Fecha f=(Fecha) o;
			if (this.dia==f.getDia() && this.mes==f.getMes() && this.anyo==f.getAnyo())
				resultado=true;
		}
		return resultado;
	}
	@Override
	public Fecha clone(){
		Fecha clonado=new Fecha();
		try{
			clonado=(Fecha) super.clone();
		}catch (CloneNotSupportedException error){
		System.out.println("Objeto no clonado");
		}
		return clonado;
	}
	@Override
	public String toString(){
		String s=("Dia "+dia+" Mes "+mes+" Anyo "+anyo);
		return (s);
	}
	@Override
	public int hashCode(){
		return (dia+mes*31+anyo*366);
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: int compareTo(Fecha comparada)
	 * Proceso M√©toddo que compara si un dos Fechas son IGUALES
	 * Precondiciones:Nada
	 * Entrada:1 Fecha
	 * Salida:1 Entero
	 * Entrada/Salida:Nada
	 * Postcondiciones:Devuelve 1 si la fecha que usa el m√©todo es mayor que la fecha que paso por parametro
	 * 0 si son iguales, -1 en caso contrario.
	 */
	@Override
	public int compareTo(Fecha comparada){
		int resultado;
		if (this.anyo<comparada.getAnyo() || (this.anyo==comparada.getAnyo() && this.mes<comparada.getMes()) || 
		   (anyo==comparada.getAnyo() && mes==comparada.getMes() && dia<comparada.getDia()))
			resultado=-1;
		else{
			if (this.anyo==comparada.getAnyo() && mes==comparada.getMes() && dia==comparada.getDia())
				resultado=0;
			else
				resultado=1;
		}
		return (resultado);
	}
}

