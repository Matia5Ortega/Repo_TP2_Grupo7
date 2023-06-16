package ar.edu.unju.fi.service;

import java.util.List;
import ar.edu.unju.fi.model.Producto;

public interface IProductoService {
	
	List<Producto> getLista();
	
	void guardar(Producto producto);
	
	Producto getBy(int codigo);
	
	void modificar(Producto producto);
	
	void eliminar(Producto producto);
	
	Producto getProducto();
	
}
