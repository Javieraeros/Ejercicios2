package testEjercicios2;

import static org.junit.Assert.*;

import org.junit.Test;

import ejerciciosSegundoTrimestre.FArrays2;
import ejerciciosSegundoTrimestre.Fecha;

public class FArrays2Test {

	@Test(expected=IllegalArgumentException.class)
	public void testCargarArray() {
		Integer[] pruebaCargar=new Integer[100];
		FArrays2.cargarArray(pruebaCargar, 60, 50);
	}


	@Test
	public void testBurbuja() {
		String[] cadenaArray={"aa","ab","ac","ad","ef"};
		String[] cArrayDes={"ef","ac","ab","aa","ad"};
		FArrays2.burbuja(cArrayDes);
		assertArrayEquals(cadenaArray, cArrayDes);
	}

	@Test
	public void testPlomada() {
		Double[] arrayDouble={-3.2,-3.2,-5.3,9.2,87.25,14.02,58.98};
		Double[] arrayOrdenado={-5.3,-3.2,-3.2,9.2,14.02,58.98,87.25};
		FArrays2.plomada(arrayDouble);
		assertArrayEquals(arrayOrdenado,arrayDouble);
	}

	/*@Test
	public void testSeleccionDirecta() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testSeleccionDirectaMejorada() {
		String[] prueba={};
		String[] ordenada={};
		FArrays2.seleccionDirectaMejorada(prueba);
		assertArrayEquals(prueba,ordenada);
	}

	@Test
	public void testInsercionDirecta() {
		Fecha miFecha=new Fecha(23,01,1996);
		Fecha miFecha2=new Fecha(22,10,1994);
		Fecha miFecha3=new Fecha(19,11,1992);
		Fecha miFecha4=new Fecha(15,8,1992);
		Fecha miFecha5=new Fecha(24,02,2009);
		Fecha[] arrayOrd={miFecha4,miFecha3,miFecha2,miFecha,miFecha5};
		Fecha[] arrayDes={miFecha,miFecha2,miFecha3,miFecha4,miFecha5};
		FArrays2.insercionDirecta(arrayDes);
		assertArrayEquals(arrayOrd,arrayDes);
	}

	@Test
	public void testCompruebaOrdenacion() {
		Fecha miFecha=new Fecha(23,01,1996);
		Fecha miFecha2=new Fecha(22,10,1994);
		Fecha miFecha3=new Fecha(19,11,1992);
		Fecha miFecha4=new Fecha(15,8,1992);
		Fecha miFecha5=new Fecha(24,02,2009);
		Fecha[] arrayOrd={miFecha4,miFecha3,miFecha2,miFecha,miFecha5};
		assertTrue(FArrays2.compruebaOrdenacion(arrayOrd)==true);
	}

}
