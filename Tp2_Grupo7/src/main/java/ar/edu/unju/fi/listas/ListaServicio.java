/*package ar.edu.unju.fi.listas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Servicio;

@Component
public class ListaServicio {
	
	private List<Servicio> servicios;

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public ListaServicio() {
		this.servicios = new ArrayList<>();
		this.servicios.add(new Servicio(1,"Juan Perez",LocalDateTime.of(23, 06, 26, 9, 00)));
		this.servicios.add(new Servicio(2,"Lucas Diaz",LocalDateTime.of(23, 06, 27, 9, 00)));
		this.servicios.add(new Servicio(3,"Maria Gomez",LocalDateTime.now()));
		this.servicios.add(new Servicio(4,"Roberto Vazquez",LocalDateTime.now()));
	}
	
	public Servicio buscarServicioById(int id) {
		if(this.getServicios().size() > 0) {	
			for(Servicio item : this.servicios) {
				if(item.getId() == id) {
					return item;
				}
			}
		}
		
		return null;
	}
}
*/