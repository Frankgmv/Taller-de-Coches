package com.frankgmv.TallerDeCoches.controllers;

import com.frankgmv.TallerDeCoches.models.Owner;
import com.frankgmv.TallerDeCoches.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public String allOwners (Model modelo) {
        modelo.addAttribute("owners", ownerService.getAllOwners());
        return "owner-list";
    }

    @GetMapping("/create")
    public String newOwnerForm (Model model) {
        model.addAttribute("owner", new Owner());
        return "owner-form";
    }
    
    @GetMapping("/edit/{id}")
    public String upateOwnerForm (@PathVariable Long id, Model model) {
        Owner updateOwner = ownerService.getOwner(id);
        model.addAttribute("owner", updateOwner);
        return "owner-form";
    }

    @PostMapping("/save")
    public String saveOwner (@ModelAttribute Owner owner){
        ownerService.createOwner(owner);
        return "redirect:/owners";
    }

    @GetMapping("/delete/{id}")
    public String deleteOwner (@PathVariable Long id){
        ownerService.deleteOwner(id);
        return "redirect:/owners";
    }
}
