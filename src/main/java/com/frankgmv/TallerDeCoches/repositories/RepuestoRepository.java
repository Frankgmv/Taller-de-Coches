package com.frankgmv.TallerDeCoches.repositories;

import com.frankgmv.TallerDeCoches.models.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Long> {
}
