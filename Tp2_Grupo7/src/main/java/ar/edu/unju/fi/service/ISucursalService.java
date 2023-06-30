package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Sucursal;

public interface ISucursalService {

List<Sucursal> getLista();
	
	void guardar(Sucursal sucursal);
	
	Sucursal getBy(int Id);
	
	void modificar(Sucursal sucursal);
	
	void eliminar(Sucursal sucursal);
	
	Sucursal getSucursal();
}
