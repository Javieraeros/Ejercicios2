package ejerciciosSegundoTrimestre;
//Nombre de mi programa=Cilindro
/**
 * En este programa calcularemos el área lateral,total y el volumen
 * de un cilindro, dado el radio y al altura del mismo
 */
 
 
/*Pseudocódigo generalizado:
 * Inicio
 * 	obtenerDatos
 * 	areaLatCilind
 * 	areaCirculo
 * 	areaTotalCilindro
 * 	volumenCilindro
 * 	mostrarResultados
 * Fin
 */
 
 import java.util.Scanner;
 public class Cilindro
 {
	public static void main(String[] args)
	{
	//declaraciónDeDatos
	double radio=0,altura=0,lateral=0,circulo=0,total=0,volumen=0;
	double pi=3.14;
	Scanner teclado=new Scanner (System.in);
	//obtenerDatos
	System.out.println("Introduce el radio del cilindro: ");
	radio=teclado.nextFloat();
	System.out.println("Introduce la altura del cilindro: ");
	altura=teclado.nextFloat();
	
	//areaLatCilindro
	lateral=2*pi*radio*altura;
	
	//areaCirculo
	circulo=pi*radio*radio;
	
	//areaTotalCilindro
	total=2*circulo+lateral;
	
	//volumenCilindro
	volumen=circulo*altura;
	
	//mostrarResultados
	System.out.println("El area lateral del cilindro es: "+lateral);
	System.out.println("El area total del cilindro es: "+total);
	System.out.println("El volumen total del cilindro es: "+volumen);
	}
}

	
