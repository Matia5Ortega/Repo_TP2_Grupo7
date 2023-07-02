package ar.edu.unju.fi.entity;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="servicios")
public class Servicio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message="Debe ingresar el nombre del paseador.")
	@Size(min=3, max=30, message="El nombre del paseador debe tener entre 3 y 30 caracteres.")
	private String nombrePaseador;
	
	@NotNull(message="Debe ingresar un horario de trabajo.")
	@DateTimeFormat(pattern="dd/MM/yy HH:mm")
	private LocalDateTime fechaHoraPaseo;
	
	private boolean estado;
	
	public Servicio() {
		
	}

	public Servicio(long id, String nombrePaseador, LocalDateTime fechaHoraPaseo, boolean estado) {
		this.id = id;
		this.nombrePaseador = nombrePaseador;
		this.fechaHoraPaseo = fechaHoraPaseo;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
