package com.frankgmv.TallerDeCoches.controllers;

import com.frankgmv.TallerDeCoches.models.Repuesto;
import com.frankgmv.TallerDeCoches.services.CocheService;
import com.frankgmv.TallerDeCoches.services.RepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/repuestos")
public class RepuestoController {

    @Autowired
    private RepuestoService repuestoService;

    @Autowired
    private CocheService cocheService;

    @GetMapping
    public String getAllRepuestos (Model model){
        model.addAttribute("repuestos", repuestoService.getAllRepuestos());
        return "repuesto-list";
    }

    @GetMapping("/create")
    public String createRepuesto(Model model){
        model.addAttribute("repuesto", new Repuesto());
        model.addAttribute("coches", cocheService.getAllCoches());
        return "repuesto-form";
    }

    @PostMapping("/save")
    public String guardarRepuesto (@ModelAttribute Repuesto repuesto){
        repuestoService.save(repuesto);
        return "redirect:/repuestos";
    }

    @GetMapping("/edit/{id}")
    public String editarRepuesto (@PathVariable Long id, Model model){
        model.addAttribute("repuesto", repuestoService.getRepuesto(id));
        model.addAttribute("coches", cocheService.getAllCoches());
        return "repuesto-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteRepuesto (@PathVariable Long id){
        repuestoService.deleteRepuesto(id);
        return "redirect:/repuestos";
    }
}
