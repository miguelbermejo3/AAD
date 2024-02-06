package ceu.ad.tema4.ejercicio2.modelo;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pedido_lineas")
public class PedidoLinea {

	@Id
	@GeneratedValue
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private UUID uidLinea;

	@Column(name = "num_linea")
	private Integer numLinea;
	private Integer cantidad;
	
	
	@ManyToOne
	@JoinColumn(name="id_articulo",nullable=false)
	private Articulo articulo;

	public UUID getUidLinea() {
		return uidLinea;
	}

	public void setUidLinea(UUID uidLinea) {
		this.uidLinea = uidLinea;
	}

	public Integer getNumLinea() {
		return numLinea;
	}

	public void setNumLinea(Integer numLinea) {
		this.numLinea = numLinea;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	@Override
	public String toString() {
		return "PedidoLinea [uidLinea=" + uidLinea + ", numLinea=" + numLinea + ", cantidad=" + cantidad + ", articulo="
				+ articulo + "]";
	}

}
