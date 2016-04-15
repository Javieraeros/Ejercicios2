package ejerciciosSegundoTrimestre;
//Nombre de mi programa: Abs
/**
 *  Este programa devuelve el valor absoluto de un 
 * número leido por teclado.
 */
 /* Pseudocódigo generalizado:
 * Inicio
 * 	leerDatos
 * 	hacerCálculos
 * Fin
 */
import java.io.*;
import java.util.Scanner;
public class AbsComando
{
public static void main(String[] args)
 {
	 //declaraciónDeVariablesYOtrosObjetos
	 int vabs=0;
	 int numero = Integer.parseInt(args[0]);
	 //hacerCálculos
	 
	 if (numero>=0)
	 vabs=numero;
	 else
	 vabs=-numero;
	 System.out.println("El número es: "+vabs);
	 }
}
