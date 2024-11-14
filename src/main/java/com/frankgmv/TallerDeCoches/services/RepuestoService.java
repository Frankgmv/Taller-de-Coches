package com.frankgmv.TallerDeCoches.services;

import com.frankgmv.TallerDeCoches.models.Repuesto;
import com.frankgmv.TallerDeCoches.repositories.RepuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RepuestoService {

    @Autowired
    private RepuestoRepository repuestoRepository;

    public List<Repuesto> getAllRepuestos () {
        return repuestoRepository.findAll();
    }

    public Repuesto getRepuesto (Long id){
        return repuestoRepository.findById(id).orElseThrow(() -> new RuntimeException("Repuesto no encontrado"));
    }

    @Transactional
    public void save (Repuesto repuesto){
        repuestoRepository.save(repuesto);
    }

    @Transactional
    public void deleteRepuesto (Long id){
        Repuesto repuestoDlt = repuestoRepository.findById(id).orElseThrow(() -> new RuntimeException("Repuesto no encontrado"));
        repuestoRepository.delete(repuestoDlt);
    }
}
