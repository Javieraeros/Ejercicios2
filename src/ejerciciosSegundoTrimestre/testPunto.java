package ejerciciosSegundoTrimestre;
/*
 * testPunto.java
 * 
 * Copyright 2016 fjrodriguez <fjrodriguez@106-06>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
import java.util.Scanner;

public class testPunto {
	
	public static void main (String args[]) {
		Punto mipunto=new Punto(2.0,5.0);
		Punto p2=new Punto(5,2);
		Punto p3= new Punto(0.0,0.0);
		double xnueva=0.0;
		double x,y;
		Scanner teclado=new Scanner(System.in);
		//System.out.println("X del punto: "+mipunto.getX());
		//System.out.println("Distancia al origen "+mipunto.DistanciaAlOrigen());
		//System.out.println("Distancia a otro punto: "+mipunto.DistanciaAOtroPunto(p2));
		//System.out.println("Nueva x del punto ");
		//xnueva=teclado.nextDouble();
		//mipunto.setX(xnueva);
		//System.out.println("Nueva x del punto, e y antigua: \n"+mipunto.getX()+"\n"+mipunto.getY());
		//System.out.println("comparación de mipunto con p2\n"+mipunto.equals(p2));
		//x=teclado.nextDouble();
		//y=teclado.nextDouble();
		//p3.setX(x); p3.setY(y);
		//System.out.println("Comparación de p2 con el punto nuevo creado: \n"+p3.compareTo(p2));
		//Punto p5=p2.clone();
		//System.out.println(p5.getX()+" "+p5.getY());
		String punto2=p2.toString();
		System.out.println(punto2);
	}
}

