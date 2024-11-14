package com.frankgmv.TallerDeCoches.controllers;

import com.frankgmv.TallerDeCoches.interfaces.Estado;
import com.frankgmv.TallerDeCoches.models.Coche;
import com.frankgmv.TallerDeCoches.services.CocheServicio;
import com.frankgmv.TallerDeCoches.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/coches")
public class CocheController {
    @Autowired
    private CocheServicio cocheServicio;

    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public String getAll (Model model){
        model.addAttribute("coches", cocheServicio.getAllCoches());
        return "coche-list";
    }

    @GetMapping("/create")
    public String createCoche (Model model){
        model.addAttribute("owners", ownerService.getAllOwners());
        model.addAttribute("coche", new Coche());
        model.addAttribute("estados", Estado.values());
        return "coche-form";
    }

    @GetMapping("/edit/{id}")
    public String getCoche(@PathVariable Long id, Model model){
        model.addAttribute("owners", ownerService.getAllOwners());
        model.addAttribute("coche", cocheServicio.getCoche(id));
        model.addAttribute("estados", Estado.values());
        return "coche-form";
    }

    @PostMapping("/save")
    public String saveCoche(@ModelAttribute Coche coche){
        cocheServicio.createCoche(coche);
        return "redirect:/coches";
    }

    @GetMapping("/delete/{id}")
    public String deleteCoche(@PathVariable Long id){
        cocheServicio.deleteCoche(id);
        return "redirect:/coches";
    }

}