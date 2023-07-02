package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.repository.IServicioRepository;
import ar.edu.unju.fi.service.IServicioService;

@Service
public class ServicioServiceMysqlImp implements IServicioService {
	
	@Autowired
	private IServicioRepository servicioRepository;
	
	@Autowired
	private Servicio servicio;
	
	public List<Servicio> getLista() {
		return (List<Servicio>) servicioRepository.findByEstado(true);
	}

	public void guardar(Servicio servicio) {
		servicioRepository.save(servicio);
	}

	public Servicio getById(long id) {
		return servicioRepository.findById(id).get();
	}

	public void modificar(Servicio servicio) {
		servicioRepository.save(servicio);
	}

	public void eliminar(Servicio servicio) {
		servicio.setEstado(false);
		servicioRepository.save(servicio);
	}


	public Servicio getServicio() {
		return servicio;
	}
	
}
