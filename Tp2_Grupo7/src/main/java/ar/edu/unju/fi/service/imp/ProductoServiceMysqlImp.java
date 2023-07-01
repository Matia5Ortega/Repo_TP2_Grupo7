package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;

@Service("productoServiceMysql")
public class ProductoServiceMysqlImp implements IProductoService  {
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private Producto producto;
	
	public List<Producto> getLista() {
		return (List<Producto>) productoRepository.findByEstado(true);
	}

	public void guardar(Producto producto, MultipartFile image) throws Exception {
		productoRepository.save(producto);
	}

	public Producto getById(long id) {
		return productoRepository.findById(id).get();
	}

	public void modificar(Producto producto, MultipartFile image) throws Exception {
		productoRepository.save(producto);
	}

	public void eliminar(Producto producto) {
		producto.setEstado(false);
		productoRepository.save(producto);
	}

	public Producto getProducto() {
		return producto;
	}

}
