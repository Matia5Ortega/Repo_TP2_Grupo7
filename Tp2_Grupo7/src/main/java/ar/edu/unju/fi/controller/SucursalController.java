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
import ar.edu.unju.fi.service.ISucursalService;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private ISucursalService sucursalService;
    
    @GetMapping("/registrar")
    public String registrar(Model model) {
        model.addAttribute("sucursal", new Sucursal());
        return "form-sucursal";
    }
    
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("sucursal") Sucursal sucursal) {
        sucursalService.guardarSucursal(sucursal);
        return "redirect:/sucursal/lista";
    }
    
    @GetMapping("/lista")
    public ModelAndView listar() {
        ModelAndView mav = new ModelAndView("lista-sucursal");
        mav.addObject("sucursales", sucursalService.obtenerTodasSucursales());
        return mav;
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Sucursal sucursal = sucursalService.obtenerSucursalPorId(id);
        model.addAttribute("sucursal", sucursal);
        return "form-sucursal";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        sucursalService.eliminarSucursal(id);
        return "redirect:/sucursal/lista";
    }
}
