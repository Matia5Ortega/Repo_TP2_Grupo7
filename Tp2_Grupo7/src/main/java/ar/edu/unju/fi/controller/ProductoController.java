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
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listado")
	public String getListadoProductosPage(Model model) {
		model.addAttribute("productos", productoService.getLista());
		return "productos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		model.addAttribute("producto", productoService.getProducto());
		model.addAttribute("edicion",false);
		return "nuevo_producto";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("producto")Producto producto, BindingResult result) {
		ModelAndView modelView = new ModelAndView("productos");
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_producto");
			modelView.addObject("producto",producto);
			return modelView;
		}
		productoService.guardar(producto);
		modelView.addObject("productos",productoService.getLista());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarProductoPage(Model model, @PathVariable(value="codigo")int codigo) {
		//Producto productoEncontrado = productoService.getBy(codigo);
		model.addAttribute("producto", productoService.getBy(codigo));
		model.addAttribute("edicion", true);
		return "nuevo_producto";
	}
	
	@PostMapping("/modificar")
	public String modificarProducto(@ModelAttribute ("producto") Producto producto) {
		productoService.modificar(producto);
		return "redirect:/productos/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarProducto(@PathVariable (value="codigo")int codigo) {
		productoService.eliminar(productoService.getBy(codigo));
		//Producto p = listaProductos.buscarProductoByCodigo(codigo);
		//listaProductos.getProductos().remove(p);		
		return "redirect:/productos/listado";
	}
	
	
}
