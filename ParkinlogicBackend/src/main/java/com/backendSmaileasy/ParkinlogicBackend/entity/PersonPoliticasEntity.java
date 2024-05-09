package com.backendSmaileasy.ParkinlogicBackend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table (name = "PersonPoliticas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PersonPoliticasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_politicas")
    private PoliticasEntity politicas;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_person")
    private PersonEntity person;

    @Column
    private Date fechaDeRegistro;
}
