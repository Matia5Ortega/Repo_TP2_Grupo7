package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Servicio;

public interface IServicioService {
	
	List<Servicio> getLista();
	
	void guardar(Servicio servicio);
	
	Servicio getBy(int id);
	
	void modificar(Servicio servicio);
	
	void eliminar(Servicio servicio);
	
	Servicio getServicio();
}
