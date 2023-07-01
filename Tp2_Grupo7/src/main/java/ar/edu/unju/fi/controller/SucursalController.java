package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.listas.*;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {
	
	@Autowired 
	private ListaSucursal listaSucursales;
	@Autowired
	private Sucursal sucursal;
	
	@GetMapping("/listado")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		return "sucursales";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		model.addAttribute("sucursal", sucursal);
		model.addAttribute("edicion", false);
		
		return "nueva_sucursal";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarSucursalPage(@ModelAttribute("sucursal")Sucursal sucursal) {
		ModelAndView modelView = new ModelAndView("sucursales");
		listaSucursales.getSucursales().add(sucursal);
		modelView.addObject("sucursales",listaSucursales.getSucursales());
		return modelView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarSucursalPage(Model model, @PathVariable(value="id")int id) {
		Sucursal outSucursal = listaSucursales.buscarSucursalById(id);
		model.addAttribute("sucursal", outSucursal);
		model.addAttribute("edicion", true);
		
		return "nueva_sucursal";
	}
	
	@PostMapping("/modificar")
	public String modificarSucursal(@ModelAttribute("sucursal")Sucursal sucursal) {
		
		Sucursal outSucursal = listaSucursales.buscarSucursalById(sucursal.getId());
				 outSucursal.setNombre(sucursal.getNombre());
				 outSucursal.setDireccion(sucursal.getDireccion());
				 outSucursal.setEmail(sucursal.getEmail());
				 outSucursal.setFechaInicio(sucursal.getFechaInicio());
				 outSucursal.setProvincia(sucursal.getProvincia());
				 outSucursal.setTelefono(sucursal.getTelefono());
		
		return "redirect:/sucursal/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarSucursalPage(Model model, @PathVariable(value="id")int id) {
		
		Sucursal outSucursal = listaSucursales.buscarSucursalById(id);
		listaSucursales.getSucursales().remove(outSucursal);
		
		return "redirect:/sucursal/listado";
	}
	
	
}