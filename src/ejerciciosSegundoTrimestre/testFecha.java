package ejerciciosSegundoTrimestre;
/*
 * testFecha.java
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


public class testFecha {
	
	public static void main (String args[]) {
		Fecha nacimiento=null;
		try{
			nacimiento=new Fecha(16,10,1582);
		}catch(IllegalArgumentException error){
			System.out.println(error);
		}
		//System.out.println(nacimiento.getDia()+"\n"+nacimiento.getMes()+"\n"+nacimiento.getAnyo());
		try{
		nacimiento.setMes(100);
		}catch (IllegalArgumentException error){
			Paco.pinta(error);
		}
		//nacimiento.setMes(3);
		//System.out.println(nacimiento.getDia()+"\n"+nacimiento.getMes()+"\n"+nacimiento.getAnyo());
		//Fecha javi=nacimiento.fechaAnterior();
		//Fecha javi2=javi.fechaPosterior();
		//System.out.println(javi.getDia()+" "+javi.getMes()+" "+javi.getAnyo());
		//Fecha javi2=nacimiento.fechaPosterior();
		//System.out.println(javi2.getDia()+" "+javi2.getMes()+" "+javi2.getAnyo());
		//Fecha javi3=nacimiento.fechaAnterior();
		//System.out.println(javi3.getDia()+" "+javi3.getMes()+" "+javi3.getAnyo());
		//Fecha javi=nacimiento.clone();
		//System.out.println(javi.compareTo(nacimiento));
		//javi=javi.fechaPosterior();
		//System.out.println(javi.getDia()+" "+javi.getMes()+" "+javi.getAnyo());
		//System.out.println(javi.toString()); 
		//System.out.println(javi.hashCode());
		//System.out.println(nacimiento.hashCode());
		//System.out.println(javi.compareTo(nacimiento));
		//Paco.pinta(javi.toString());
		//Paco.pinta(30);
		//Paco.pinta(nacimiento.equals(javi2));
		Paco.pinta(nacimiento.toString());
		
	}
}

