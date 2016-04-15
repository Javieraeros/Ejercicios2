package ejerciciosSegundoTrimestre;
/* *******************
 * Estudio de Interfaz
 * *******************
 * Propiedades
 * 
 * Basicas:
 * tamanyo entero,consultable y modificable
 * array Object[],consultable y modificable
 * incremento entero, consultable y modificable
 * ordeanada booleano consultable
 * 
 * Derivadas:
 * 
 * Compartidas:
 * 
 * Restricciones:
 * tamanyo mayor que 0,incremento mayor o igual que 0
 * ********
 * Interfaz
 * ********
 * Consultores:
 * int getTamanyo();
 * int getIncremento();
 * E getElemento(int index);
 * boolean getOrdenado();
 * 
 * Modificadores:
 * void setTamanyo(int tamanio)
 * void setElemento(int index,E elemento)
 * void setIncremento(int incremento)
 * 
 * M�todos a�adidos:
 * void indiceValido(int index);
 * int ordenaNulos();
 * void ordenaArray();
 * private void ordenaArrayDeVerdad();
 * void aniadeElemento(E elemento)
 * void aniadeElemento(int index,E elemento); 
 * void insertaElemento(E elemento);
 * int buscaElemento(E elemento);
 * private int buscaElementoDes(E elemento);
 * private int buscaElementoOrd(E elemento);
 * void quitaElemento(E elemento);
 * void quitaElemento(int index);
 * void ajustaTamanyo(); 
 * 
 * 
 * M�todos Sobreescritos:
 * boolean equals (object o);
 * miArray clone();
 * int hashCode();
 * String toString();
 * 
 */


public class miArray<E extends Comparable<E>> {
	//Atributos
	private int tamanyo;
	private Object[] array;
	private int incremento;
	private boolean ordenado=false;
	
	//constructores
	public miArray(){
		tamanyo=1;
		incremento=1;
		array=new Object[tamanyo];
	}
	
	public miArray (int tamanyo)throws IllegalArgumentException{
		if(tamanyo>0){
			this.tamanyo=tamanyo;
			incremento=1;
			this.array= new Object[tamanyo];
		}else{
			throw new IllegalArgumentException("Error, el tamanyo no puede ser menor que 1");
		}
	}
	
	public miArray(int tamanyo,int incremento)throws IllegalArgumentException{
		if(tamanyo>0 && incremento>=0){
			this.tamanyo=tamanyo;
			this.incremento=incremento;
			this.array= new Object[tamanyo];
		}else{
			throw new IllegalArgumentException("Error, el tamanyo no puede ser menor que 1, y el incremento menor que 0");
		}
	}
	
	
	//Consultores
	public int getTamanyo(){
		return this.tamanyo;
	}
	
	public E getElemento(int index){
		indiceValido(index);
		return (E)this.array[index];
	}
	
	
	public int getIncremento(){
		return this.incremento;
	}
	
	public boolean getOrdenado(){
		return this.ordenado;
	}
	
	/*public E[] getArray(){
		return (E[]) this.array;
	}*/
	
	//Modificadores
	public void setTamanyo(int tamanyoNuevo)throws IllegalArgumentException{
		if(tamanyo>0){
			Object[] copiaArray=new Object[tamanyoNuevo];
			if(tamanyoNuevo>this.tamanyo){
				for(int i=0;i<this.tamanyo;i++){
					copiaArray[i]=getElemento(i);
				}
				this.array=copiaArray;
				this.tamanyo=tamanyoNuevo;
			}else{
				for(int i=0;i<tamanyoNuevo;i++){
					copiaArray[i]=getElemento(i);
				}
				this.array=copiaArray;
				this.tamanyo=tamanyoNuevo;
			}
		}else{
			throw new IllegalArgumentException("Error, el tamanyo no puede ser menor que 1");
		}
	}
	
	public void setElemento(int index,E valor){
		indiceValido(index);
		this.array[index]=valor;
		ordenado=false;
	}
	
	public void setIncremento(int incremento)throws IllegalArgumentException{
		if(incremento>0){
			this.incremento=incremento;
		}else{
			throw new IllegalArgumentException("El incremento debe ser mayor que 0");
		}
	}
	
	//M�todos a�adidos
	public void indiceValido(int index)throws IndexOutOfBoundsException{
		if (index<0 || index>=tamanyo)
			throw new IndexOutOfBoundsException("El �ndice debe estar entre 0 y "+(tamanyo-1));
	}
	
	
	 /* 
	 * Interfaz 
	 * Cabecera: int ordenaNulos()
	 * Proceso:Ordena un array poniendo los nulos al final de esta y devuelve el �ndice del �ltimo elemento del array no nulo
	 * Precondiciones:Ninguna
	 * Entrada:Nada
	 * Salida:1 entero
	 * Entrada/Salida:array con los nulos ordenados
	 * Postcondiciones:entero asociado al nombre
	 */
	
	private int ordenaNulos(){
		int i,j,finalArray=tamanyo-1;
		for(i=0;i<tamanyo;i++){
			if(getElemento(i)==null){
				for(j=tamanyo-1;j>i;j--){
					setElemento(i,getElemento(i-1));
				}
				setElemento(finalArray,null);
				finalArray=finalArray-1;
			}
		}
		return finalArray;
	}
	
	public void ordenaArray(){
		if(ordenado==true){
			System.out.println("El array ya está ordenado");
		}else{
			ordenaArrayDeVerdad();
			this.ordenado=true;
		}
	}
	
	private void ordenaArrayDeVerdad(){
		int i,j;
		int finalArray;
		E aux;
		/* Para evitar problemas futuros (o presentes), pondremos todos los objetos nulos al final, haciendo 
		 * una primera "ordenacion" */
		finalArray=ordenaNulos();
		/*A continuación, solo tomamos los valores del array distintos de "null" mediante la variable finalArray*/
		for(i=1;i<finalArray;i++){
			for(j=i;j>0 && getElemento(j-1).compareTo(getElemento(j))>0;j--){ 
				aux=getElemento(j);
				setElemento(j,getElemento(j-1));
				setElemento(j-1,aux);
			}
		}
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: aniadeElemento(E elemento)
	 * Proceso:a�ade un elemento al final del array,o bien, en el �ltimo Null que encuentre empezando por la cola
	 * Precondiciones:Si el array est� lleno, se aumentar� su tama�o en el incremento, y se introducir� posteriormente
	 * Entrada:Un elemento
	 * Salida:Nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:Se a�adir� un elemento al array
	 */
	//Hablar sobre como solucioner que me pon�a el elemento en el primer Null (20 minutos para solucionarlo)
	
	public void aniadeElemento(E elemento){
		int i=tamanyo;
		this.ordenado=false;
		/**primero comprobamos el �ltimo elemento,ya que si NO es nulo tendremos que aumentar el tama�o del array para poder a�adir el elemento
		 * al final sin sobreescribir ning�n otro elemento*/
		if (getElemento(tamanyo-1)!=null){
			this.setTamanyo(tamanyo+incremento);
			setElemento(tamanyo-incremento,elemento);
		}else{
			//for(i=0;i<tamanyo && getElemento(i)!=null;i++){
			for(i=tamanyo-1;i>=0 && getElemento(i)==null;i--);
			
			setElemento(i+1,elemento);
		}
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: void aniadeElemento(int index,E elemento)
	 * Proceso:A�ade un elemento al array en el �ndice �ndicado, desplazando los dem�s elemento una posici�n hacia abajo
	 * Precondiciones:El �ndice debe ser v�lido
	 * Entrada:1 �ndice y 1 entero
	 * Salida:Nada
	 * Entrada/Salida: Nada
	 * Postcondiciones:Aumentar� el tama�o del array de ser necesario, adem�s de a�adir el elemento
	 */
	
	public void aniadeElemento(int indice,E elemento){
		indiceValido(indice);
		if (getElemento(tamanyo-1)!=null){
			setTamanyo(tamanyo+incremento);
		}
		//for(int i=indice+1;i<tamanyo;i++){    me copia el elemento siguiente del elemento a insertar muchas veces
		for(int i=tamanyo-1;i>indice;i--){
			setElemento(i,getElemento(i-1));
		}
		setElemento(indice,elemento);
		this.ordenado=false;
	}
	
	/* 
	 * Interfaz 
	 * Cabecera:void insertaElemento(E elemento)
	 * Proceso:Inserta un elemento en su posici�n correspondiente. En caso de haya un elemento en dicho array, lo insertar� en la posici�n posterior
	 * Precondiciones:El array debe estar ordenado
	 * Entrada:Un elemento
	 * Salida:Nada
	 * Entrada/Salida:El array con el elemento
	 * Postcondiciones:Soltar� una excepci�n si el array no est� ordenado
	 */
	
	public void insertaElemento(E elemento)throws IllegalArgumentException{
		if(!ordenado){
			throw new IllegalArgumentException("Error, el array no est� ordenado");
		}else{
			/* Recorreremos el array y compararemos el elemento con cada uno de los elementos del array con el m�todo
			 * compareTo, en el momento en que este cambio de negativo a positivo, paramos e insertamos el elemento en la casilla posterior
			 */
			int i;
			for(i=0;i<tamanyo && (getElemento(i).compareTo(elemento)<0 || getElemento(i)==null );i++);  /*Puede que sea el �ltimo elemento, 
																										  por lo que tendremos que comprobar el null*/
			
			/**
			 * En caso de que tengamos que insertarlo despu�s del �ltimo,usamos el m�todo aniadeElemento, que lo a�ade por defecto al final
			 */
			if(i<tamanyo){
				aniadeElemento(i-1,elemento);
			}else{
				aniadeElemento(elemento);
				this.ordenado=true; //Puesto que a�ade elemento lo pone a false, pero desde este m�todo, estamos seguros que el array est� ordenado
			}
		}
	}
	
	 /* 
	 * Interfaz 
	 * Cabecera:int buscaElemento(E elemento)
	 * Proceso:Busca un elemento el el array
	 * Precondiciones:Ninguna
	 * Entrada:Un elemento tipo E
	 * Salida:Un entero
	 * Entrada/Salida:Nada
	 * Postcondiciones:Devolver� el INDICE de un elemento si el array est� ordenado (pero no sabremos si es el primer indice), 
	 * 				   el PRIMER INDICE del array si �ste est� desordenado,
	 * 				   o -1 si el elemento no est� en el array
	 */
	
	public int buscaElemento(E elemento){
		int resultado=-1;
		if(ordenado){
			resultado=buscaElementoOrd(elemento);
		}else{
			resultado=buscaElementoDes(elemento);
		}
		return resultado;
	}
	
	/* 
	 * Interfaz 
	 * Cabecera:int buscaElementoOrd(E elemento)
	 * Proceso:Busca un elemento en el array ORDENADO
	 * Precondiciones:Ninguna
	 * Entrada:Un elemento tipo E
	 * Salida:Un entero
	 * Entrada/Salida:Nada
	 * Postcondiciones:Devolverá el INDICE del elemento, o -1 si el elemento no está en el array.
	 * 					No sabremos si es el
	 */
	
	private int buscaElementoOrd(E elemento){
		int i,resultado=-1,inicio=0,fin;
		int mitad;
		boolean existe=false;
		//Buscamos dónde no haya objetos nulos
		for(i=0;i<tamanyo && getElemento(i)!=null;i++);
		fin=i-1;
		
		while(!existe){
			mitad=(inicio+fin)/2;
			if(getElemento(mitad).compareTo(elemento)==0){
				existe=true;
				resultado=mitad;
			}else{
				if(getElemento(mitad).compareTo(elemento)==1){
					fin=mitad-1;
				}else{
					inicio=mitad+1;
				}
			}
		}
		return resultado;
	}
	
	/* 
	 * Interfaz 
	 * Cabecera:int buscaElementoDes(E elemento)
	 * Proceso:Busca un elemento el el array DESORDENADO
	 * Precondiciones:Ninguna
	 * Entrada:Un elemento tipo E
	 * Salida:Un entero
	 * Entrada/Salida:Nada
	 * Postcondiciones:Devolverá el INDICE del PRIMER elemento, o -1 si el elemento no está en el array
	 */
	
	private int buscaElementoDes(E elemento){
		int i,resultado=-1;
		boolean existe=false;
		for(i=0;i<tamanyo && !existe;i++){
			if(getElemento(i)!=null){     //para que no nos salte la expecion NullPointer
				if(getElemento(i).equals(elemento)){
					resultado=i;
					existe=true;
				}
			}
		}
		return resultado;
	}
	
	
	/* 
	 * Interfaz 
	 * Cabecera:void quitaElemento(E elemento) throws IllegalArgumentException
	 * Proceso:quita un elemento del array, caso de existir
	 * Precondiciones:Ninguna
	 * Entrada:un elemento
	 * Salida:Ninguna
	 * Entrada/Salida:El array al que se le va a quitar el elemento
	 * Postcondiciones:En caso de que no quite el elemento,mostrar� un mensaje por pantalla. en caso de quitarlo, dejar� el espacio a null
	 */
	
	public void quitaElemento(E elemento)throws IllegalArgumentException{
		int indice;
		indice=buscaElemento(elemento);
		if(indice!=-1){
			setElemento(indice,null);
		}else{
			throw new IllegalArgumentException("error, el elemento no ha sido borrado");
		}
	}
	
	
	/* 
	 * Interfaz 
	 * Cabecera:void quitaElemento(int index)
	 * Proceso:quita el elemento del array de dicha, caso de indice valido(llama a dicha funcion)
	 * Precondiciones:Ninguna
	 * Entrada:un entero
	 * Salida:Ninguna
	 * Entrada/Salida:El array al que se le va a quitar el elemento
	 * Postcondiciones:En caso de que no quite el elemento,mostrar� un mensaje por pantalla. en caso de quitarlo, dejar� el espacio a null
	 */
	
	public void quitaElemento(int index){
		indiceValido(index);
		setElemento(index,null);
	}
	
	 /* 
	  * Interfaz 
	  * Cabecera: public void ajustaTamanyo()
	  * Proceso:elimina los nulos de un array(estando o no ordenado) y reduciendo su tama�o la necesario
	  * Precondiciones:ninguna
	  * Entrada:ninguna
	  * Salida:ninguna
	  * Entrada/Salida:el array a a justar
	  * Postcondiciones:el array no contendr� ninguna valor nulo,y mantendr� su estado de ordenacion
	  */
	
	public void ajustaTamanyo(){
		int tamanyo;
		tamanyo=ordenaNulos();
		setTamanyo(tamanyo+1);
		
	}
	
	//M�todos Heredados
	
/* 
	 * Interfaz 
	 * Cabecera: boolean equals(Object o)
	 * Proceso: Método que devuelve si un objeto es IGUAL a otro
	 * Precondiciones:Ninguna
	 * Entrada:1 objeto
	 * Salida: 1 booleano
	 * Entrada/Salida:Nada
	 * Postcondiciones:Booleano asociado al nombre, true si los objetos son iguales, false en caso contrario
	 */
	@Override
	public boolean equals(Object o){
		boolean resultado=false;
		if(o instanceof miArray && o!=null){
			miArray ma=(miArray) o;
			if (this.tamanyo==ma.getTamanyo() && this.incremento==ma.getIncremento() && this.array.equals(ma)){
				resultado=true;
			}
		}
		return resultado;
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: int compareTo(miArray comparada)
	 * Proceso M�toddo que compara si un dos miArrays son IGUALES
	 * Precondiciones:Nada
	 * Entrada:1 miArray
	 * Salida:1 Entero
	 * Entrada/Salida:Nada
	 * Postcondiciones:Devuelve 1 si el array que usa el m�todo es mayor que el array que paso por parametro
	 * 0 si son iguales, -1 en caso contrario.
	 * Un array ser� mayor que otro si su primer t�rmino es mayor, 0 si son iguales y -1 en caso contrario
	 */
	
	
}

