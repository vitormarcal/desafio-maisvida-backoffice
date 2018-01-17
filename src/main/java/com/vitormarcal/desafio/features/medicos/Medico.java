package com.vitormarcal.desafio.features.medicos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Document
@Data
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    private String id;
    private String primeiroNome;
    private String ultimoNome;
    private String email;
    private Boolean ativo;
    private Boolean ocupado;

    @CreatedDate
    private LocalTime createdDate;

    @LastModifiedDate
    private LocalTime lastModifiedDate;


}
