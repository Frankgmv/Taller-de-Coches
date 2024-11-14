package com.frankgmv.TallerDeCoches.controllers;

import com.frankgmv.TallerDeCoches.interfaces.EstadoFinal;
import com.frankgmv.TallerDeCoches.models.Factura;
import com.frankgmv.TallerDeCoches.services.CocheService;
import com.frankgmv.TallerDeCoches.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private CocheService cocheService;

    @GetMapping
    public String getAllFacturas (Model model){
        model.addAttribute("facturas", facturaService.getAllFacturas());
        return "factura-list";
    }

    @GetMapping("/create")
    public String createFactura (Model model){
        model.addAttribute("factura", new Factura());
        model.addAttribute("coches", cocheService.getAllCoches());
        model.addAttribute("estadoFnl", EstadoFinal.values());
        return "factura-form";
    }

    @PostMapping("/save")
    public String saveFactura (@ModelAttribute Factura factura){
        facturaService.saveFactura(factura);
        System.out.println(factura.toString());
        return "redirect:/facturas";
    }

    @GetMapping("/edit/{id}")
    public String editFactura (@PathVariable Long id, Model model){
        model.addAttribute("factura", facturaService.getFactura(id));
        model.addAttribute("coches", cocheService.getAllCoches());
        model.addAttribute("estadoFnl", EstadoFinal.values());
        return "factura-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteFactura (@PathVariable Long id){
        facturaService.deleteFactura(id);
        return "redirect:/facturas";
    }
}
