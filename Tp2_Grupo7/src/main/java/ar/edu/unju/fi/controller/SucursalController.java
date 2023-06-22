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

import ar.edu.unju.fi.model.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private ISucursalService sucursalService;
    
    @GetMapping("/listado")
    public String getListaSucursalesPage(Model model) {
        model.addAttribute("sucursales", sucursalService.getLista());
        return "sucursales";
    }

    @GetMapping("/nuevo")
    public String getNuevaSucursalPage(Model model) {
        model.addAttribute("sucursal", sucursalService.getSucursal());
        model.addAttribute("edicion", false);
        return "nueva_sucursal";
    }

    @PostMapping("/guardar")
    public ModelAndView guardarSucursalPage(@ModelAttribute("sucursal") Sucursal sucursal) {
        ModelAndView modelView = new ModelAndView("sucursales");
        sucursalService.guardar(sucursal);
        modelView.addObject("sucursales", sucursalService.getLista());
        return modelView;
    }

    @GetMapping("/modificar/{id}")
    public String getModificarSucursalPage(Model model, @PathVariable(value = "id") int id) {
        Sucursal outSucursal = sucursalService.getBy(id);
        model.addAttribute("sucursal", outSucursal);
        model.addAttribute("edicion", true);
        return "nueva_sucursal";
    }

    @PostMapping("/modificar")
    public String modificarSucursal(@ModelAttribute("sucursal") Sucursal sucursal) {
        sucursalService.modificar(sucursal);
        return "redirect:/sucursal/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarSucursalPage(Model model, @PathVariable(value = "id") int id) {
        Sucursal outSucursal = sucursalService.getBy(id);
        sucursalService.eliminar(outSucursal);
        return "redirect:/sucursal/listado";
    }
}
