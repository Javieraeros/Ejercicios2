package ejerciciosSegundoTrimestre;
public class testFArrays2 {
	
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
			FArrays.cargarArray(array,-50,50);
			FArrays.pintaArray(array);
			Paco.pinta("Array Ordenada: ");
		}
		//********Burbuja********
		//FArrays2.burbuja(array);
		//FArrays2.pintaArray(array);
		
		//********Plomada********
		//FArrays2.plomada(array);
		//FArrays2.pintaArray(array);
		
		
		//****SeleccionDirecta****
		//FArrays2.seleccionDirecta(array);
		//FArrays2.pintaArray(array);
		
		
		//*****SeleccionDirectaMejorada******
		//FArrays2.seleccionDirectaMejorada(array);
		//FArrays2.pintaArray(array);
		
		//***InsercionDirecta****
		FArrays2.insercionDirecta(array);
		FArrays2.pintaArray(array);
	}
}

