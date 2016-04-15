package ejerciciosSegundoTrimestre;
/*
 * testCirculo.java
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
public class testCirculo {
	
	public static void main (String args[]) {
		Scanner teclado=new Scanner(System.in);
		Punto centro=new Punto(0,2);
		Circulo circ=new Circulo (centro,54);
		//System.out.println("x del centro: "+circ.getCentroX());
		//System.out.println("y del centro: "+circ.getCentroY());
		//System.out.println("radio del circulo: "+circ.getRadio());
		//circ.setCentroX(teclado.nextDouble());
		//circ.setCentroY(teclado.nextDouble());
		//circ.setRadio(teclado.nextDouble());
		//System.out.println("Coordenada x del circulo: ");
		//System.out.println(circ.getCentroX());
		//System.out.println("Coordenada y del circulo");
		//System.out.println(circ.getCentroY());
		//System.out.println("Radio del circulo:");
		//System.out.println(circ.getRadio());
		Circulo c2=circ.clone();
		//System.out.println("Creando circulo clonado");
		//System.out.println("Cambiando el centro del circulo");
		//circ.setRadio(8);
		//System.out.println("Coordenado x del centro del circulo clonado"+c2.getCentroX());
		//System.out.println("Coordenada x del centro del circulo"+circ.getCentroX());
		//System.out.println(circ.equals(c2));
		//System.out.println(circ.hashCode());
		//System.out.println(circ.toString());
		System.out.println(circ.compareTo(c2));
	}
}

