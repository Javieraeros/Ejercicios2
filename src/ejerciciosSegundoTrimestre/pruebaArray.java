package ejerciciosSegundoTrimestre;

/*
 * pruebaArray.java
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


public class pruebaArray {
	
	public static void main (String args[]) {
		int[][] prueba={{1,2,3,4,5},{0,1,2,3,4}};
		for(int i=0;i<prueba.length;i++){
			for (int j=0;j<prueba[0].length;j++){
				Paco.pinta(prueba[i][j]);
			}
		}
	}
}

