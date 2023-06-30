package ar.edu.unju.fi.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.fi.entity.Producto;

public interface IProductoService {
	
	List<Producto> getLista();
	
	void guardar(Producto producto, MultipartFile image) throws Exception;
	
	Producto getBy(int codigo);
	
	void modificar(Producto producto, MultipartFile image)throws Exception;
	
	void eliminar(Producto producto);
	
	Producto getProducto();
	
}
