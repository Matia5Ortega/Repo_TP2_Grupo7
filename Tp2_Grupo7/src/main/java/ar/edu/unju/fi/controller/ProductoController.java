package ar.edu.unju.fi.controller;

import java.net.MalformedURLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.service.IProductoService;
import ar.edu.unju.fi.util.UploadFile;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	@Qualifier("productoServiceMysql")
	private IProductoService productoService;
	@Autowired
	private UploadFile uploadFile;
	
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
	public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("producto")Producto producto, BindingResult result, @RequestParam("producto_imagen") MultipartFile image) throws Exception {
		ModelAndView modelView = new ModelAndView("productos");
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_producto");
			modelView.addObject("producto",producto);
			return modelView;
		}
		productoService.guardar(producto,image);
		modelView.addObject("productos",productoService.getLista());
		return modelView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarProductoPage(Model model, @PathVariable(value="id")long id) {
		model.addAttribute("producto", productoService.getById(id));
		model.addAttribute("edicion", true);
		return "nuevo_producto";
	}
	
	@PostMapping("/modificar")
	public String modificarProducto(@ModelAttribute ("producto") Producto producto, @RequestParam("producto_imagen") MultipartFile image) throws Exception {
		productoService.modificar(producto,image);
		return "redirect:/productos/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable (value="id")long id) {
		productoService.eliminar(productoService.getById(id));		
		return "redirect:/productos/listado";
	}
	
	@GetMapping("/uploads/{filename}")
	public ResponseEntity<Resource> goImage(@PathVariable String filename) {
		Resource resource = null;
		try {
			resource = uploadFile.load(filename);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
}
