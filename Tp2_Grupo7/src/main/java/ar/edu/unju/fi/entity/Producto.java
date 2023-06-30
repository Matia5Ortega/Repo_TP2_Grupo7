package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Component
public class Producto {
	@NotEmpty(message="Debe ingresar el nombre del producto.")
	@Size(min=3, max=30, message="El nombre del producto debe tener entre 3 y 30 caracteres.")
	private String nombre;
	@NotNull(message="Debe ingresar un codigo.")
	@Positive(message="Debe ingresar un valor positivo.")
	@Min(value=1, message="El valor mínimo permitido es 1")
	//@Pattern(regexp="[1-9]+", message="")
	private int codigo;
	@NotNull(message="Debe ingresar un precio.")
	@Positive(message="Debe ingresar un valor positivo.")
	private double precio;
	@NotEmpty(message="Debe ingresar una categoria.")
	@Size(min=5, max=30, message="La categoria debe tener entre 5 y 30 caracteres.")
	private String categoria;
	@NotNull(message="Debe ingresar un valor para descuento.")
	@PositiveOrZero(message="Debe ingresar un valor positivo o cero.")
	@Min(value=0,message="El valor minimo permitido es cero.")
	private int descuento;
	@NotEmpty(message="Debe ingresar una descripción.")
	@Size(min=5, max=250, message="La descripción debe tener entre 5 y 250 caracteres.")
	private String descripcion;
	private String imagen;
	
	public Producto() {
		
	}

	public Producto(String nombre, int codigo, double precio, String categoria, int descuento, String descripcion,String imagen) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
		
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public double calcularDescuento() {
		return this.precio - this.precio*this.descuento/100;
	}
}
