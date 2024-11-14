package com.frankgmv.TallerDeCoches.services;

import com.frankgmv.TallerDeCoches.models.Coche;
import com.frankgmv.TallerDeCoches.repositories.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CocheService {
    @Autowired
    private CocheRepository cocheRepository;

    public List<Coche> getAllCoches (){
        return cocheRepository.findAll();
    }

    public Coche getCoche(Long id){
        return cocheRepository.findById(id).orElseThrow(()-> new RuntimeException("Coche no contrado"));
    }

    @Transactional
    public void createCoche(Coche coche){
        cocheRepository.save(coche);
    }

    @Transactional
    public void deleteCoche(Long id){
        Coche dltCoche = cocheRepository.findById(id).orElseThrow(() -> new RuntimeException("Coche no encontrado"));
        cocheRepository.delete(dltCoche);
    }
}
