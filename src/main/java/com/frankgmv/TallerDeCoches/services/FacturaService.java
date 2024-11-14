package com.frankgmv.TallerDeCoches.services;

import com.frankgmv.TallerDeCoches.models.Factura;
import com.frankgmv.TallerDeCoches.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> getAllFacturas (){
        return facturaRepository.findAll();
    }

    public Factura getFactura (long id){
        return facturaRepository.findById(id).orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

    @Transactional
    public void saveFactura (Factura factura){
        facturaRepository.save(factura);
    }

    @Transactional
    public void deleteFactura (Long id){
        Factura facturaDlt = facturaRepository.findById(id).orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        facturaRepository.delete(facturaDlt);
    }

}
