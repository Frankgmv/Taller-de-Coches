package com.frankgmv.TallerDeCoches.repositories;

import com.frankgmv.TallerDeCoches.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
