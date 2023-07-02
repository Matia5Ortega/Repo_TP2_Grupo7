package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView; 
import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	
	@Autowired
	private IServicioService servicioService;
	
	@GetMapping("/listado")
	public String getListadoServicioPage(Model model) {
		model.addAttribute("servicios", servicioService.getLista());
		return "servicios_de_paseo";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoServicioPage(Model model) {
		model.addAttribute("servicio", servicioService.getServicio());
		model.addAttribute("edicion",false);
		return "nuevo_servicio";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarServicioPage(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result){
		ModelAndView modelView = new ModelAndView("servicios_de_paseo");
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_servicio");
			modelView.addObject("servicio",servicio);
			return modelView;
		}
		servicioService.guardar(servicio);
		modelView.addObject("servicios",servicioService.getLista());
		return modelView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarServicioPage(Model model, @PathVariable(value="id")int id) {
		model.addAttribute("servicio",servicioService.getById(id));
		model.addAttribute("edicion", true);
		return "nuevo_servicio";
	}
	
	@PostMapping("/modificar")
	public String modificarServicio(@ModelAttribute ("servicio")Servicio servicio){
		servicioService.modificar(servicio);
		return "redirect:/servicios/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarServicio(@PathVariable (value="id")int id) {
		servicioService.eliminar(servicioService.getById(id));		
		return "redirect:/servicios/listado";
	}

}
