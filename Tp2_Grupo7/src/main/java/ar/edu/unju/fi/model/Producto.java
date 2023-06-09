package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Producto {
	private String nombre;
	private int codigo;
	private double precio;
	private String categoria;
	private int descuento;
	private String descripcion;
	
	public Producto() {
		
	}

	public Producto(String nombre, int codigo, double precio, String categoria, int descuento, String descripcion) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
		this.descripcion = descripcion;
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

	public double calcularDescuento() {
		return this.precio - this.precio*this.descuento/100;
	}
}
