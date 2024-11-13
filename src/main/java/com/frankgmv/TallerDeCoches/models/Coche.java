package com.frankgmv.TallerDeCoches.models;

import com.frankgmv.TallerDeCoches.interfaces.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricula;
    private String descripcion;
    private Date fechaEntrada;
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Owner owner;

    @OneToMany(mappedBy = "coche", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Repuesto> repuestos;

    @OneToMany(mappedBy = "coche", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DetallesMantenimiento> detallesMantenimiento;

    @OneToMany(mappedBy = "coche", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Factura> facturas;
}
