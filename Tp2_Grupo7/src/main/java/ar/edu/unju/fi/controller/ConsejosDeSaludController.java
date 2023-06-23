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

import ar.edu.unju.fi.model.ConsejosDeSalud;
import ar.edu.unju.fi.service.IConsejosDeSaludService;

@Controller
@RequestMapping("/consejos")
public class ConsejosDeSaludController {

    @Autowired
    private IConsejosDeSaludService consejosDeSaludService;
    
    @GetMapping("/listado")
    public String getListaConsejosPage(Model model) {
        model.addAttribute("consejos", consejosDeSaludService.getLista().getConsejos());
        return "consejos";
    }

    @GetMapping("/nuevo")
    public String getNuevoConsejoPage(Model model) {
        model.addAttribute("consejo", consejosDeSaludService.getConsejo());
        model.addAttribute("edicion", false);
        return "nuevo_consejo";
    }

    @PostMapping("/guardar")
    public ModelAndView guardarConsejoPage(@ModelAttribute("consejo") ConsejosDeSalud consejo) {
        ModelAndView modelView = new ModelAndView("consejos");
        consejosDeSaludService.guardar(consejo);
        modelView.addObject("consejos", consejosDeSaludService.getLista().getConsejos());
        return modelView;
    }

    @GetMapping("/modificar/{id}")
    public String getModificarConsejoPage(Model model, @PathVariable(value = "id") int id) {
        ConsejosDeSalud outConsejo = consejosDeSaludService.getById(id);
        model.addAttribute("consejo", outConsejo);
        model.addAttribute("edicion", true);
        return "nuevo_consejo";
    }

    @PostMapping("/modificar")
    public String modificarConsejo(@ModelAttribute("consejo") ConsejosDeSalud consejo) {
        consejosDeSaludService.modificar(consejo);
        return "redirect:/consejos/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarConsejoPage(Model model, @PathVariable(value = "id") int id) {
        ConsejosDeSalud outConsejo = consejosDeSaludService.getById(id);
        consejosDeSaludService.eliminar(outConsejo);
        return "redirect:/consejos/listado";
    }
}
