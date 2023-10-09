package ejercicio4.modelo;

import java.math.BigDecimal;

public class LineaPedido {

	private Long idPedido;
	private int numLinea;
	private String articulo;
	private BigDecimal precio;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public int getNumLinea() {
		return numLinea;
	}

	public void setNumLinea(int numLinea) {
		this.numLinea = numLinea;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "LineaPedido [idPedido=" + idPedido + ", numLinea=" + numLinea + ", articulo=" + articulo + ", precio="
				+ precio + "]";
	}

}
