package com.frankgmv.TallerDeCoches.controllers;

import com.frankgmv.TallerDeCoches.models.DetallesMantenimiento;
import com.frankgmv.TallerDeCoches.services.CocheService;
import com.frankgmv.TallerDeCoches.services.DetallesMantenimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detalles")
public class DetalleController {

    @Autowired
    private DetallesMantenimientosService detallesMantenimientosService;

    @Autowired
    private CocheService cocheService;

    @GetMapping
    public String getAllDetalles(Model model){
        model.addAttribute("detalles", detallesMantenimientosService.getAllMantenimientos());
        return "detalle-list";
    }

    @GetMapping("/create")
    public String createDetalle(Model model){
        model.addAttribute("detalle", new DetallesMantenimiento());
        model.addAttribute("coches", cocheService.getAllCoches());
        return "detalle-form";
    }

    @PostMapping("/save")
    public String saveDetalle(@ModelAttribute DetallesMantenimiento detallesMantenimiento){
        detallesMantenimientosService.saveDetalle(detallesMantenimiento);
        return "redirect:/detalles";
    }

    @GetMapping("/edit/{id}")
    public String editDetalle(@PathVariable Long id, Model model){
        model.addAttribute("detalle", detallesMantenimientosService.getDetelleById(id));
        model.addAttribute("coches", cocheService.getAllCoches());
        return "detalle-form";
    }

    @GetMapping("/delete/{id}")
    public String DeleteDetalle(@PathVariable Long id){
        detallesMantenimientosService.deleteDetalle(id);
        return "redirect:/detalles";
    }
}
