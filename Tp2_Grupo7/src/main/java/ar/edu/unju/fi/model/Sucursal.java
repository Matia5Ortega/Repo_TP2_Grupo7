package ar.edu.unju.fi.model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
public class Sucursal {
	
	private int id;
	
	@NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;
    
	@NotEmpty(message = "La dirección no puede estar vacía")
    private String direccion;
    
	@NotEmpty(message = "La provincia no puede estar vacía")
    private String provincia;
    
	@DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate fechaInicio;
    
	@Email(message = "El email no es válido")
    private String email;
    
	@NotEmpty(message = "El teléfono no puede estar vacío")
	@Size(min = 10, max = 15, message = "El teléfono debe tener entre 10 y 15 caracteres")
    private String telefono;
    
    // Constructor parametrizado
    
	public Sucursal(int id, String nombre, String direccion, String provincia, LocalDate fechaInicio, String email,
			String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fechaInicio = fechaInicio;
		this.email = email;
		this.telefono = telefono;
	}
	
	public Sucursal() {
		
	}
	
    // Getters y setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}