package ejerciciosSegundoTrimestre; 
/*
 * ***********
 * Propiedades
 * ***********
 * Basicas:
 * Nombre cadena,consultable y modificable
 * Precio real,consultable y modificable
 * Coste real,consultable y modificable
 * Stock entero,consultable y modificable
 * Descripción cadena,consultable y modificable
 * Vendido entero,consultable y modificable
 * Moneda cadena, consultable y modificable
 * 
 * Derivadas:
 * TotalFacturado real,consultable
 * Ganancias real,consultable
 * 
 * Compartidas:
 *
 * *************
 * Restricciones
 * *************
 * Precio,coste, stock y vendido no pueden ser menor que 0
 * Vendido solo podrá aumentar, nunca disminuir,salvo devolución
 * 
 * 
 * ********
 * Interfaz
 * ********
 * Constructores:
 * Articulo()
 * Articulo(String nombre,double precio,double coste, int stock,String descripcion,int vendido)
 * 
 * Consultores:
 * String getNombre()
 * Double getPrecio()
 * Double getCoste()
 * Int getStock()
 * String getDescripción()
 * Int getVendido()
 * Double getTotalFacturado()
 * Double getGanancias()
 * 
 * Modificadores:
 * void setNombre(String nombre)
 * void setPrecio(double precio)
 * void setCoste(double coste)
 * void setStock(int stock)
 * void setDescripcion(String descripcion)
 * void setVendido(int vendido)
 * 
 * Métodos añadidos:
 * void devolucion(int devuelto)
 * 
 * *********************
 * Métodos Sobreescritos
 * *********************
 * boolean equals(Object o);
 * Articulo clone();
 * String toString();
 * int hashCode();
 * ind compareTo(Articulo comparado);
*/
import java.lang.annotation.*;
public class Articulo implements Cloneable,Comparable <Articulo> {
	//atributos
	private String nombre;
	private double precio;
	private double coste;
	private int stock;
	private String descripcion;
	private int vendido;
	public static String moneda="€"; 
	//constructores
	public Articulo(){
		nombre="";
		precio=1;
		coste=1;
		stock=10;
		descripcion="";
		vendido=0;
		moneda="$";
	}
	
	public Articulo(String nombre,double precio,double coste, int stock,String descripcion,int vendido) throws IllegalArgumentException{
		if (precio<0 || coste<0 || vendido<0){
			if (precio<0){
				IllegalArgumentException eprecio=new IllegalArgumentException("Error en el precio");
				throw eprecio;
			}
			if (coste<0){
				IllegalArgumentException ecoste=new IllegalArgumentException("Error en el coste");
				throw ecoste;
			}
			if (precio<0){
				IllegalArgumentException evendido=new IllegalArgumentException("Error en la cantidad de artículos vendidos");
				throw evendido;
			}
		}else{
			this.nombre=nombre;
			this.precio=precio;
			this.coste=coste;
			this.stock=stock;
			this.descripcion=descripcion;
			this.vendido=vendido;
		}
	}
	
	/*public Articulo(String nombre,double precio,double coste, int stock,String descripcion,int vendido,String moneda) throws IllegalArgumentException{
		if (precio<0 || coste<0 || vendido<0){
			if (precio<0){
				IllegalArgumentException eprecio=new IllegalArgumentException("Error en el precio");
				throw eprecio;
			}
			if (coste<0){
				IllegalArgumentException ecoste=new IllegalArgumentException("Error en el coste");
				throw ecoste;
			}
			if (precio<0){
				IllegalArgumentException evendido=new IllegalArgumentException("Error en la cantidad de artículos vendidos");
				throw evendido;
			}
		}else{
			this.nombre=nombre;
			this.precio=precio;
			this.coste=coste;
			this.stock=stock;
			this.descripcion=descripcion;
			this.vendido=vendido;
			this.moneda=moneda;
		}
	}*/
	
	//consultores
	public String getNombre(){
		return nombre;
	}
	public double getPrecio(){
		return precio;
	}
	
	public double getCoste(){
		return coste;
	}
	public int getStock(){
		return stock;
	}
	public String getDescripcion(){
		return descripcion;
	}
	public int getVendido(){
		return vendido;
	}
	/*public String getMoneda(){
		return moneda;
	}*/
	public double getTotalFacturado(){
		return (vendido*precio);
	}
	public double getGanancias(){
		return (vendido*(precio-coste));
	}
	//Modificadores
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public void setPrecio(double precio) throws IllegalArgumentException{
		if (precio<0){
			IllegalArgumentException yeeeje=new IllegalArgumentException("Déjate ir, que el precio no puede ser menos que cero");
			throw yeeeje;
		}else{
			this.precio=precio;
		}
	}
	public void setCoste(double coste) throws IllegalArgumentException{
		if (coste<0){
			IllegalArgumentException error=new IllegalArgumentException("el coste no puede ser menor que 0 ;)");
			throw error;
		}else{
			this.coste=coste;
		}
	}
	public void setStock(int stock) throws IllegalArgumentException{
		if (stock<0){
			IllegalArgumentException error=new IllegalArgumentException("El stock no puede ser negativo");
			throw error;
		}else{
			this.stock=stock;
		}
	}
	public void setDescripcion(String descripcion){
		this.descripcion=descripcion;
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: void setVendido(int vendido)
	 * Proceso: Nos permiete AUMENTAR en una cantidad el número de productos vendidos
	 * Precondiciones:Número mayor que 0
	 * Entrada:1 entero
	 * Salida:nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:Ninguna
	 */
	
	public void setVendido(int vendido)throws IllegalArgumentException{
		if (vendido<0){
			IllegalArgumentException error=new IllegalArgumentException("El numero de articulos vendidos no puede ser negativo");
			throw error;
		}else{
			this.vendido+=vendido;
		}
	}
	
	/*public void setMoneda(String moneda){
		this.moneda=moneda;
	}*/
	
	/* 
	 * Interfaz 
	 * Cabecera: void devolucion(int devuelto)
	 * Proceso: Método que devuelve un artículo, es decir, disminuye el número de artículso vendidos
	 * Precondiciones: Número mayor que 0
	 * Entrada:1 entero
	 * Salida:nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:Caso de que el número sea menor qeu 0, no hace anda y devuelve una excepción
	 */
	
	
	public void devolucion(int devuelto)throws IllegalArgumentException{
		if (devuelto<=0){
			IllegalArgumentException e=new IllegalArgumentException("El número de artículso devueltos no puede ser negativo");
			throw e;
		}else{
			this.vendido-=devuelto;
		}
	}
	
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
		boolean igual=false;
		if (o!=null && o instanceof Articulo){
			Articulo a=(Articulo) o;
			if(nombre==a.getNombre() && coste==a.getCoste())
				igual=true;
		}
		return igual;
	}
	
	@Override
	public Articulo clone(){
		Articulo clonado=null;
		try{
			clonado= (Articulo) super.clone();
		}catch(CloneNotSupportedException error){
			System.out.println("Error, no se ha podido clonar el Artículo");
		}
		return clonado;
	}
	
	@Override
	public String toString(){
		return ("Nombre: "+nombre+"\nPrecio: "+precio+moneda+"\nCoste: "+coste+moneda+"\nStock: "+stock+"\nDescripcion: "+descripcion+"\nVendido: "+vendido);
	}
	
	@Override
	public int hashCode(){
		return ((int) (nombre.length()+precio*100-coste*101)*stock-descripcion.length()+vendido);
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: int compareTo(Articulo comparado)
	 * Proceso Métoddo que compara si un dos articulos son IGUALES
	 * Precondiciones:Nada
	 * Entrada:1 Fecha
	 * Salida:1 Entero
	 * Entrada/Salida:Nada
	 * Postcondiciones:Devuelve 1 si el artículo que usa el método tiene mayores ganancias que el artículo que paso por parametro
	 * 0 si son iguales, -1 en caso contrario.
	 */
	 
	@Override
	public int compareTo(Articulo comparado){
		int comparacion;
		if (getGanancias()>comparado.getGanancias()){
			comparacion=1;
		}else{
			if(getGanancias()==comparado.getGanancias())
				comparacion=0;
			else
				comparacion=-1;
		}
		return comparacion;
	}
	
}

