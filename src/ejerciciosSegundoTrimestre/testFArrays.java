package ejerciciosSegundoTrimestre;
public class testFArrays {
	
	public static void main (String args[]) {
		Integer[] array;
		if (args.length>0){
			int i;
			array=new Integer[args.length];
			for(i=0;i<args.length;i++){
				array[i]=Integer.parseInt(args[i]);
			}
		}else{
			array=new Integer[10];
			FArrays.cargarArray(array,-5,5);
			FArrays.pintaArray(array);
			Paco.pinta("Array Ordenada: ");
		}
		//********Burbuja********
		FArrays.burbuja(array);
		FArrays.pintaArray(array);
		
		//********Plomada********
		//FArrays.plomada(array);
		
		
		//****SeleccionDirecta****
		//FArrays ar=new FArrays();
		//ar.seleccionDirecta(array);
		
		
		//*****SeleccionDirectaMejorada******
		//FArrays ar=new FArrays();
		//ar.seleccionDirectaMejorada(array);
		
		//***InsercionDirecta****
		/*FArrays ar=new FArrays();
		int[] array2;
		array2=ar.insercionDirecta(array);
		FArrays.pintaArray(array2);*/
	}
}

