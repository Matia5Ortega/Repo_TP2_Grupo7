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
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ListaProducto listaProductos;
	
	@Autowired
	private Producto producto;
	
	@GetMapping("/listado")
	public String getListadoProductosPage(Model model) {
		model.addAttribute("productos", listaProductos.getProductos());
		return "productos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		model.addAttribute("producto", producto);
		model.addAttribute("edicion",false);
		return "nuevo_producto";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@ModelAttribute("producto")Producto producto) {
		ModelAndView modelView = new ModelAndView("productos");
		listaProductos.getProductos().add(producto);
		modelView.addObject("productos",listaProductos.getProductos());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarProductoPage(Model model, @PathVariable(value="codigo")int codigo) {
		Producto productoEncontrado = listaProductos.buscarProductoByCodigo(codigo);
		model.addAttribute("producto", productoEncontrado);
		model.addAttribute("edicion", true);
		return "nuevo_producto";
	}
	
	@PostMapping("/modificar")
	public String modificarProducto(@ModelAttribute ("producto") Producto producto) {
		Producto p = listaProductos.buscarProductoByCodigo(producto.getCodigo());
		p.setNombre(producto.getNombre());
		p.setCodigo(producto.getCodigo());
		p.setPrecio(producto.getPrecio());
		p.setDescuento(producto.getDescuento());
		p.setCategoria(producto.getCategoria());
		p.setDescripcion(producto.getDescripcion());
		return "redirect:/productos/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarProducto(@PathVariable (value="codigo")int codigo) {
		Producto p = listaProductos.buscarProductoByCodigo(codigo);
		listaProductos.getProductos().remove(p);		
		return "redirect:/productos/listado";
	}
	
	
}
