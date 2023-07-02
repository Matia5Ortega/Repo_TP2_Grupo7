package ar.edu.unju.fi.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ar.edu.unju.fi.entity.Producto;

public interface IProductoRepository extends CrudRepository<Producto,Long> {
	
	public List<Producto> findByEstado(boolean estado);


}
