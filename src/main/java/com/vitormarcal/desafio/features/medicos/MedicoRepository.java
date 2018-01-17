package com.vitormarcal.desafio.features.medicos;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicoRepository extends MongoRepository<Medico, String> {
}
