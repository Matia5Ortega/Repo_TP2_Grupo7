package ar.edu.unju.fi.model;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Component
public class Servicio {
	
	@NotNull(message="Debe ingresar un número identificador.")
	@Positive(message="El identificador debe ser un número mayor a cero.")
	private int id;
	
	@NotEmpty(message="Debe ingresar el nombre del paseador.")
	@Size(min=3, max=30, message="El nombre del paseador debe tener entre 3 y 30 caracteres.")
	private String nombrePaseador;
	
	@NotNull(message="Debe ingresar un horario de trabajo.")
	@DateTimeFormat(pattern="dd/MM/yy HH:mm")
	private LocalDateTime fechaHoraPaseo;
	
	public Servicio() {
		
	}

	public Servicio(int id, String nombrePaseador, LocalDateTime fechaHoraPaseo) {
		this.id = id;
		this.nombrePaseador = nombrePaseador;
		this.fechaHoraPaseo = fechaHoraPaseo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrePaseador() {
		return nombrePaseador;
	}

	public void setNombrePaseador(String nombrePaseador) {
		this.nombrePaseador = nombrePaseador;
	}

	public LocalDateTime getFechaHoraPaseo() {
		return fechaHoraPaseo;
	}

	public void setFechaHoraPaseo(LocalDateTime fechaHoraPaseo) {
		this.fechaHoraPaseo = fechaHoraPaseo;
	}
	
}
