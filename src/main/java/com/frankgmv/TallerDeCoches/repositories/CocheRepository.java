package com.frankgmv.TallerDeCoches.repositories;

import com.frankgmv.TallerDeCoches.models.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {
}
