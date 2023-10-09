package ejercicio4.app;

import java.math.BigDecimal;
import java.time.LocalDate;

import ejercicio4.modelo.LineaPedido;
import ejercicio4.modelo.Pedido;
import ejercicio4.service.PedidoService;
import ejercicio4.service.PedidoServiceException;

public class Test {

	public static void main(String[] args) {
		Long idPedido = 133L;
		Pedido pedido = new Pedido();
		pedido.setIdPedido(idPedido);
		pedido.setFechaPedido(LocalDate.now());
		pedido.setFechaEntrega(LocalDate.of(2023, 11, 1));
		pedido.setCliente("Miguel Bermejo");

		for (int i = 1; i <= 3; i++) {
			LineaPedido linea = new LineaPedido();
			linea.setArticulo("Artículo " + i);
			linea.setPrecio(new BigDecimal(456));
			pedido.getLineas().add(linea);
		}

		PedidoService service = new PedidoService();
		try {
			service.crearPedido(pedido);
		} catch (PedidoServiceException e) {
			e.printStackTrace();
		}

	}

}
