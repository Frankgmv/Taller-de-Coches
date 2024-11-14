package com.frankgmv.TallerDeCoches.models;

import com.frankgmv.TallerDeCoches.interfaces.EstadoFinal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaSalida;

    @Enumerated(EnumType.STRING)
    private EstadoFinal estadoFinal;

    @ManyToOne
    @JoinColumn(name = "id_coche")
    private Coche coche;

    @Override
    public String toString() {
        return "Factura{" +
                "coche=" + coche.getId() +
                ", id=" + id +
                ", fechaSalida=" + fechaSalida +
                ", estadoFinal=" + estadoFinal +
                '}';
    }
}
