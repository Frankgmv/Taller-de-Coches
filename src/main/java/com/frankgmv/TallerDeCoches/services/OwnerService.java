package com.frankgmv.TallerDeCoches.services;

import com.frankgmv.TallerDeCoches.models.Owner;
import com.frankgmv.TallerDeCoches.repositories.CocheRepository;
import com.frankgmv.TallerDeCoches.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private CocheRepository cocheRepository;


    public List<Owner> getAllOwners (){
        return ownerRepository.findAll();
    }

    public Owner getOwner (Long id){
        return ownerRepository.findById(id).orElse(null);
    }

    @Transactional
    public void createOwner(Owner owner){
        ownerRepository.save(owner);
    }

    @Transactional
    public void deleteOwner (Long id){
        Owner getOwnerDB = ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Dueño no encontrado"));
        ownerRepository.delete(getOwnerDB);
    }
}
