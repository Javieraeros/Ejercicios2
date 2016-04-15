package ejerciciosSegundoTrimestre;
public class TipoGenerico <T>
{
	private T valor;
	
	TipoGenerico () {
		valor = null;
	}
	
	TipoGenerico (T valor) {
		this.valor = valor;
	}
	
	public void setValor (T valor) {
		this.valor = valor;
	}
	
	public T getValor () {
		return valor;
	}
}
