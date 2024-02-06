package ceu.ad.tema4.ejercicio3.service;

import java.util.List;

import ceu.ad.tema4.ejercicio3.modelo.CentroComercial;
import ceu.ad.tema4.ejercicio3.modelo.Marca;
import ceu.ad.tema4.ejercicio3.modelo.Pais;
import ceu.ad.tema4.ejercicio3.modelo.Tienda;

public class ComercialServiceImpl implements ComercialService {

	@Override
	public List<Pais> buscarPaises(String filtro) throws ComercialException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarMarca(Marca marca) throws ComercialException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertarCentroComercial(CentroComercial cc) throws ComercialException {
		// TODO Auto-generated method stub

	}

	@Override
	public CentroComercial consultarCentroComercial(String uuidCentro) throws ComercialException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tienda consularTienda(Long idTienda) throws ComercialException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarTienda(Long idTienda) throws ComercialException {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarCentroComercial(String uuidCentro) throws ComercialException {
		// TODO Auto-generated method stub

	}

}
