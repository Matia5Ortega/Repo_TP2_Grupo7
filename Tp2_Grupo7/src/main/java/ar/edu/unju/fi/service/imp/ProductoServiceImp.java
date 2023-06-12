package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.service.IProductoService;

@Service
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private ListaProducto listaProductos;
	@Autowired
	private Producto producto;
	
	public List<Producto> getLista() {
		return listaProductos.getProductos();
	}

	public void guardar(Producto producto) {
		listaProductos.getProductos().add(producto);
	}

	public Producto getBy(int codigo) {
		return listaProductos.buscarProductoByCodigo(codigo);
	}

	public void modificar(Producto producto) {
		Producto p = listaProductos.buscarProductoByCodigo(producto.getCodigo());
		p.setNombre(producto.getNombre());
		p.setCodigo(producto.getCodigo());
		p.setPrecio(producto.getPrecio());
		p.setDescuento(producto.getDescuento());
		p.setCategoria(producto.getCategoria());
		p.setDescripcion(producto.getDescripcion());
	}

	public void eliminar(Producto producto) {
		listaProductos.getProductos().remove(producto);
	}

	public Producto getProducto() {
		return producto;
	}
	
}