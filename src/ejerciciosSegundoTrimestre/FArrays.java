package ejerciciosSegundoTrimestre;
public class FArrays {
	
	/* 
	 * Interfaz 
	 * Cabecera: void cargaArray(int[] array,int minimo,int maximo)
	 * Proceso:Carga un array con valores aleatorios, entre un mínimo y un máximo
	 * Precondiciones:Mínimo menor que máximo
	 * Entrada:2 enteros
	 * Salida:Nada
	 * Entrada/Salida:1 array
	 * Postcondiciones:Array por referencia, lanza una excepción si el valor mínimo es mayor o igual que el máximo
	 */
	
	public static void cargarArray(Integer[] array,int minimo,int maximo)throws IllegalArgumentException{
		if(minimo>=maximo){
			throw new IllegalArgumentException("Error, el mínimo debe ser menor estrico que el máximo");
		}else{
			int i;
			for(i=0;i<array.length;i++){
				array[i]=(int) ((Math.random())*(maximo-minimo)+minimo);
			}
		}
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: void pintaArray(T[] array)
	 * Proceso:pinta un array en pantalla
	 * Precondiciones:ninguna
	 * Entrada:1 array
	 * Salida:nada
	 * Entrada/Salida:nada
	 * Postcondiciones:pinta en pantalla
	 */
	static <T> void pintaArray(T[] array){
		for (int i=0;i<array.length;i++){
			Paco.pinta(array[i]);
		}
	}
	
	
	/* 
	 * Interfaz 
	 * Cabecera: void burbuja(int[] array)
	 * Proceso: método que ordena una array, de menor a mayor por le método de la burbuja
	 * Precondiciones:Ninguna
	 * Entrada:Nada
	 * Salida:Nada
	 * Entrada/Salida:1 array
	 * Postcondiciones:devolución por referencia
	 */
	
	public static <T extends Comparable<T>> void burbuja (T[] array){
		int i,j,tam=array.length;
		T aux;
		for (i=0;i<tam-1;i++){
			for(j=tam-1;j>i;j--){
				if(array[j].compareTo(array[j-1])<0){
					aux=array[j];
					array[j]=array[j-1];
					array[j-1]=aux;
				}
			}
		}
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: void plomada(int[] array)
	 * Proceso: método que ordena una array, de menor a mayor por el método de la plomada
	 * Precondiciones:Ninguna
	 * Entrada:Nada
	 * Salida:Nada
	 * Entrada/Salida:1 array
	 * Postcondiciones:devolución por referencia
	 */
	
	static void plomada (int[] array){
		int i,j,aux,tam=array.length;
		for (i=tam-1;i>0;i--){
			for(j=0;j<i;j++){
				if(array[j]>array[j+1]){
					aux=array[j];
					array[j]=array[j+1];
					array[j+1]=aux;
				}
			}
		}
	} 
	/* 
	 * Interfaz 
	 * Cabecera: void seleccionDirecta (int[] array)
	 * Proceso:método que ordena un array de menor a mayor por le método de la selección directa
	 * Precondiciones:ninguna
	 * Entrada:Nada
	 * Salida:Nada
	 * Entrada/Salida: 1 array
	 * Postcondiciones:array pasado por referencia
	 */
	
	void seleccionDirecta(int[] array){
		int i,j,minimo,tam=array.length,aux;
		for(i=0;i<tam;i++){
			minimo=i;
			for(j=i+1;j<tam;j++){
				if(array[j]<array[minimo]){
					minimo=j;
				}
			}
			aux=array[i];
			array[i]=array[minimo];
			array[minimo]=aux;
		}
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: void seleccionDirectaMejorada (int[] array)
	 * Proceso:método que ordena un array de menor a mayor por le método de la selección directa mejorada, evitando la última iteración (innecesaria)
	 * Precondiciones:ninguna
	 * Entrada:Nada
	 * Salida:Nada
	 * Entrada/Salida: 1 array
	 * Postcondiciones:array pasado por referencia
	 */
	
	void seleccionDirectaMejorada(int[] array){
		int i,j,minimo,tam=array.length,aux;
		for(i=0;i<tam-1;i++){
			minimo=i;
			for(j=i+1;j<tam;j++){
				if(array[j]<array[minimo]){
					minimo=j;
				}
			}
			aux=array[i];
			array[i]=array[minimo];
			array[minimo]=aux;
		}
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: int[] insercionDirecta (int[] array)
	 * Proceso: Método que ordena de mayor a menor un array
	 * Precondiciones:Ninguna
	 * Entrada:1 array
	 * Salida:1 array
	 * Entrada/Salida:nada
	 * Postcondiciones:Array asociada al nombre
	 */
	
	protected int[] insercionDirecta(int[] arrayEntrada){
		int i,j,tam=arrayEntrada.length,aux;
		int[] array=arrayEntrada.clone();
		for(i=1;i<tam;i++){
			for(j=i;j>0 && array[j-1]>array[j];j--){  //Tan sencillo como poner primero la condición j>0 ANTES que la otra
				aux=array[j];
				array[j]=array[j-1];
				array[j-1]=aux;
			}
		}
		return array;
	}
}

