package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@GetMapping("/inicio")
	public String paginaIndex(){
		return "index";
	}
	
	@GetMapping("sucursales")
	public String paginaSucursales() {
		return "sucursales";
	}
	
	@GetMapping("productos")
	public String paginaProductos() {
		return "productos";
	}
	
	@GetMapping("servicios")
	public String paginaServicioDePaseo() {
		return "servicios_de_paseo";
	}
	
	@GetMapping("consejos_de_salud")
	public String paginaConsejosDeSalud() {
		return "consejos_de_salud";
	}
	
	@GetMapping("contactanos")
	public String paginaContacto() {
		return "contactanos";
	}
}
