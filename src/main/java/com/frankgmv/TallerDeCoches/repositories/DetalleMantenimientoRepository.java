package com.frankgmv.TallerDeCoches.repositories;

import com.frankgmv.TallerDeCoches.models.DetallesMantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleMantenimientoRepository extends JpaRepository<DetallesMantenimiento, Long> {
}
