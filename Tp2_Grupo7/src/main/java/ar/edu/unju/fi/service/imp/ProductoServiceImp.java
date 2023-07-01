/*package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.service.IProductoService;
import ar.edu.unju.fi.util.UploadFile;

@Service("productoServiceImp")
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private ListaProducto listaProductos;
	@Autowired
	private Producto producto;
	@Autowired
	private UploadFile uploadFile;
	
	public List<Producto> getLista() {
		return listaProductos.getProductos();
	}

	public void guardar(Producto producto, MultipartFile image) throws Exception {
		if (!image.isEmpty()) {
			producto.setImagen(uploadFile.copy(image));
		}
		listaProductos.getProductos().add(producto);
	}

	public Producto getBy(int codigo) {
		return listaProductos.buscarProductoByCodigo(codigo);
	}

	public void modificar(Producto producto, MultipartFile image) throws Exception {
		Producto p = listaProductos.buscarProductoByCodigo(producto.getCodigo());
		p.setNombre(producto.getNombre());
		p.setCodigo(producto.getCodigo());
		p.setPrecio(producto.getPrecio());
		p.setDescuento(producto.getDescuento());
		p.setCategoria(producto.getCategoria());
		p.setDescripcion(producto.getDescripcion());
		if (!image.isEmpty()) {
			if (p.getImagen() != null && p.getImagen().length() > 0)
				uploadFile.delete(p.getImagen());
			p.setImagen(uploadFile.copy(image));
		}
	}

	public void eliminar(Producto producto) {
		listaProductos.getProductos().remove(producto);
	}

	public Producto getProducto() {
		return producto;
	}
}*/