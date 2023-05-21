package ar.edu.unju.fi.model;

import java.time.LocalDateTime;

public class Servicio {
	private String nombre_paseador;
	private LocalDateTime fechaHoraPaseo;
	private int nombre_perros[];
	
	public Servicio(String nombre_paseador, LocalDateTime fechaHoraPaseo, int[] nombre_perros) {
		this.nombre_paseador = nombre_paseador;
		this.fechaHoraPaseo = fechaHoraPaseo;
		this.nombre_perros = nombre_perros;
	}

	public String getNombre_paseador() {
		return nombre_paseador;
	}

	public void setNombre_paseador(String nombre_paseador) {
		this.nombre_paseador = nombre_paseador;
	}

	public LocalDateTime getFechaHoraPaseo() {
		return fechaHoraPaseo;
	}

	public void setFechaHoraPaseo(LocalDateTime fechaHoraPaseo) {
		this.fechaHoraPaseo = fechaHoraPaseo;
	}

	public int[] getNombre_perros() {
		return nombre_perros;
	}

	public void setNombre_perros(int[] nombre_perros) {
		this.nombre_perros = nombre_perros;
	}
	
}
