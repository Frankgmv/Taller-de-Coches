package com.frankgmv.TallerDeCoches.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetallesMantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String proceso;
    private String tiempo;
    private double valor;

    @ManyToOne
    @JoinColumn(name = "coche_id")
    private Coche coche;
}
