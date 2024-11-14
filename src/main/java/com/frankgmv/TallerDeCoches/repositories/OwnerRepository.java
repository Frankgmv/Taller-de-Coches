package com.frankgmv.TallerDeCoches.repositories;

import com.frankgmv.TallerDeCoches.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
