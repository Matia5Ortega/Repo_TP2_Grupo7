package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "sucursales")
public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotEmpty(message = "El nombre no puede estar vacío")
	@Column(name = "nombre")
    private String nombre;
    
	@NotEmpty(message = "La dirección no puede estar vacía")
	@Column(name = "direccion")
    private String direccion;
    
	@NotEmpty(message = "La provincia no puede estar vacía")
	@Column(name = "provincia")
    private String provincia;
    
	@Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    
	@Email(message = "El email no es válido")
	@Column(name = "email")
    private String email;
    
	@NotEmpty(message = "El teléfono no puede estar vacío")
	@Size(min = 10, max = 15, message = "El teléfono debe tener entre 10 y 15 caracteres")
	@Column(name = "telefono")
    private String telefono;
    
    // Constructor parametrizado
    
	public Sucursal(int i, String nombre, String direccion, String provincia, LocalDate fechaInicio, String email,
			String telefono) {
		super();
		this.id = i;
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
