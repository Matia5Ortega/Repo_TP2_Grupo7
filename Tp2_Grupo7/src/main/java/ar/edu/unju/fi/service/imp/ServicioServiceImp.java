package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Servicio;
import ar.edu.unju.fi.service.IServicioService;

@Service
public class ServicioServiceImp implements IServicioService{

	@Autowired
	private ListaServicio listaServicio;
	@Autowired
	private Servicio servicio;
	
	public List<Servicio> getLista() {
		return listaServicio.getServicios();
	}

	public void guardar(Servicio servicio) {
		listaServicio.getServicios().add(servicio);
	}

	public Servicio getBy(int id) {
		return listaServicio.buscarServicioById(id);
	}

	public void modificar(Servicio servicio) {
		Servicio s = listaServicio.buscarServicioById(servicio.getId());
		s.setId(servicio.getId());
		s.setNombrePaseador(servicio.getNombrePaseador());
		s.setFechaHoraPaseo(servicio.getFechaHoraPaseo());
	}

	public void eliminar(Servicio servicio) {
		listaServicio.getServicios().remove(servicio);
	}

	public Servicio getServicio() {
		return servicio;
	}
	
}
