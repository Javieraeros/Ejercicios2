package testEjercicios2;

import static org.junit.Assert.*;

import org.junit.Test;

import ejerciciosSegundoTrimestre.Rombo;
import ejerciciosSegundoTrimestre.miArray;

public class miArrayTest {

	@Test
	public void testMiArray() {
		miArray<String> javi=new miArray<String>();
		assertTrue(javi.getTamanyo()==1);
		assertTrue(javi.getIncremento()==1);
		assertFalse(javi.getOrdenado());
	}

	@Test
	public void testMiArrayTamanyo() {
		miArray<String> javi=new miArray<String>(10);
		assertEquals(10,javi.getTamanyo());
	}

	@Test
	public void testMiArrayIncremento() {
		miArray<String> javi=new miArray<String>(100,25);
		assertEquals(100,javi.getTamanyo());
		assertEquals(25,javi.getIncremento());
	}
	
	@Test
	public void testGetTamanyo() {
		miArray<String> javi=new miArray<String>(10);
		assertEquals(10,javi.getTamanyo());
	}

	@Test
	public void testGetElemento() {
		miArray<Rombo> javiR=new miArray<Rombo>(3,3);
		Rombo r1=new Rombo(4,8);
		Rombo r2=new Rombo(2,1);
		Rombo r3=new Rombo(1,3);
		Rombo r4=new Rombo(2,5);
		Rombo r5=new Rombo(1,3);
		Rombo r6=new Rombo(2,0.5);
		Rombo r7=new Rombo(6,1);
		javiR.aniadeElemento(r1);
		javiR.aniadeElemento(r2);
		javiR.aniadeElemento(r3);
		javiR.aniadeElemento(r4);
		javiR.aniadeElemento(r5);
		javiR.aniadeElemento(r6);
		javiR.aniadeElemento(r7);
		assertEquals(r3,javiR.getElemento(2));
	}


	@Test
	public void testGetIncremento() {
		miArray<Rombo> javiR=new miArray<Rombo>(3);
		Rombo r1=new Rombo(4,8);
		Rombo r2=new Rombo(2,1);
		Rombo r3=new Rombo(1,3);
		Rombo r4=new Rombo(2,5);
		Rombo r5=new Rombo(1,3);
		Rombo r6=new Rombo(2,0.5);
		Rombo r7=new Rombo(6,1);
		javiR.aniadeElemento(r1);
		javiR.aniadeElemento(r2);
		javiR.aniadeElemento(r3);
		javiR.aniadeElemento(r4);
		javiR.aniadeElemento(r5);
		javiR.aniadeElemento(r6);
		javiR.aniadeElemento(r7);
		assertEquals(1,javiR.getIncremento());
		miArray<Rombo> javiR2=new miArray<Rombo>(3,50);
		javiR2.aniadeElemento(r1);
		javiR2.aniadeElemento(r2);
		javiR2.aniadeElemento(r3);
		javiR2.aniadeElemento(r4);
		javiR2.aniadeElemento(r5);
		javiR2.aniadeElemento(r6);
		javiR2.aniadeElemento(r7);
		assertEquals(50,javiR2.getIncremento());
	}

	@Test
	public void testGetOrdenado() {
		miArray<Rombo> javiR=new miArray<Rombo>(3);
		Rombo r1=new Rombo(4,8);
		Rombo r2=new Rombo(2,1);
		Rombo r3=new Rombo(1,3);
		Rombo r4=new Rombo(2,5);
		Rombo r5=new Rombo(1,3);
		Rombo r6=new Rombo(2,0.5);
		Rombo r7=new Rombo(6,1);
		javiR.aniadeElemento(r1);
		javiR.aniadeElemento(r2);
		javiR.aniadeElemento(r3);
		javiR.aniadeElemento(r4);
		javiR.aniadeElemento(r5);
		javiR.aniadeElemento(r6);
		javiR.aniadeElemento(r7);
		assertEquals(false,javiR.getOrdenado());
	}

	/*@Test
	public void testGetArray(){
		miArray<Integer> javiI=new miArray<Integer>(10,5);
		javiI.aniadeElemento(50);
		javiI.aniadeElemento(841);
		javiI.aniadeElemento(50561);
		javiI.aniadeElemento(8450);
		javiI.aniadeElemento(-654);
		javiI.aniadeElemento(654);
		javiI.aniadeElemento(21);
		javiI.aniadeElemento(2);
		javiI.aniadeElemento(-9844);
		javiI.aniadeElemento(842);
		Integer[] arrayI=new Integer[10];
		arrayI=javiI.getArray();
	}*/
	
	
	@Test
	public void testSetTamanyo() {
		miArray<Integer> javiI=new miArray<Integer>(10,5);
		javiI.aniadeElemento(50);
		javiI.aniadeElemento(841);
		javiI.aniadeElemento(50561);
		javiI.aniadeElemento(8450);
		javiI.aniadeElemento(-654);
		javiI.aniadeElemento(654);
		javiI.aniadeElemento(21);
		javiI.aniadeElemento(2);
		javiI.aniadeElemento(-9844);
		javiI.aniadeElemento(842);
		javiI.setTamanyo(5);
		assertEquals(5,javiI.getTamanyo());
	}

	@Test
	public void testSetElemento() {
		miArray<Integer> javiI=new miArray<Integer>(10,5);
		javiI.aniadeElemento(50);
		javiI.aniadeElemento(841);
		javiI.aniadeElemento(50561);
		javiI.aniadeElemento(8450);
		javiI.aniadeElemento(-654);
		javiI.aniadeElemento(654);
		javiI.aniadeElemento(21);
		javiI.aniadeElemento(2);
		javiI.aniadeElemento(-9844);
		javiI.aniadeElemento(842);
		javiI.setElemento(5,29);
		assertEquals((Integer) 29,javiI.getElemento(5));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSetElementoException() {
		miArray<Integer> javiI=new miArray<Integer>(10,5);
		javiI.aniadeElemento(50);
		javiI.aniadeElemento(841);
		javiI.aniadeElemento(50561);
		javiI.aniadeElemento(8450);
		javiI.aniadeElemento(-654);
		javiI.aniadeElemento(654);
		javiI.aniadeElemento(21);
		javiI.aniadeElemento(2);
		javiI.aniadeElemento(-9844);
		javiI.aniadeElemento(842);
		javiI.setElemento(5,29);
		assertEquals((Integer) 29,javiI.getElemento(16));
	}

	@Test
	public void testSetIncremento() {
		miArray<Integer> javiI=new miArray<Integer>(10,5);
		javiI.aniadeElemento(50);
		javiI.aniadeElemento(841);
		javiI.aniadeElemento(50561);
		javiI.aniadeElemento(8450);
		javiI.aniadeElemento(-654);
		javiI.aniadeElemento(654);
		javiI.aniadeElemento(21);
		javiI.aniadeElemento(2);
		javiI.aniadeElemento(-9844);
		javiI.aniadeElemento(842);
		javiI.setIncremento(10);
		assertEquals(10,javiI.getIncremento());
	}

	/*@Test
	public void testIndiceValido() {
		fail("Not yet implemented");
	}

	/*@Test
	public void testOrdenaArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testAniadeElementoE() {
		fail("Not yet implemented");
	}

	@Test
	public void testAniadeElementoIntE() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertaElemento() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscaElemento() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}*/

}
