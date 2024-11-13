package com.frankgmv.TallerDeCoches.models;

import com.frankgmv.TallerDeCoches.interfaces.EstadoFinal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaSalida;
    private EstadoFinal estadoFinal;

    @ManyToOne
    @JoinColumn(name = "id_coche")
    private Coche coche;

    //
}
