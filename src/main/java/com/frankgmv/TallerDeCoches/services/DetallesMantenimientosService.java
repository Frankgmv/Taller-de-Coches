package com.frankgmv.TallerDeCoches.services;

import com.frankgmv.TallerDeCoches.models.DetallesMantenimiento;
import com.frankgmv.TallerDeCoches.repositories.DetalleMantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetallesMantenimientosService {

    @Autowired
    private DetalleMantenimientoRepository detalleMantenimientoRepository;

    public List<DetallesMantenimiento> getAllMantenimientos (){
        return detalleMantenimientoRepository.findAll();
    }

    public DetallesMantenimiento getDetelleById (Long id){
        return detalleMantenimientoRepository.findById(id).orElseThrow(() -> new RuntimeException("Detalle no encontrado"));
    }

    @Transactional
    public void saveDetalle (DetallesMantenimiento detallesMantenimiento){
        detalleMantenimientoRepository.save(detallesMantenimiento);
    }

    @Transactional
    public void deleteDetalle (Long id){
        DetallesMantenimiento detalleDelete = detalleMantenimientoRepository.findById(id).orElseThrow(() -> new RuntimeException("Detalle no encontrado"));
        detalleMantenimientoRepository.delete(detalleDelete);
    }
}
