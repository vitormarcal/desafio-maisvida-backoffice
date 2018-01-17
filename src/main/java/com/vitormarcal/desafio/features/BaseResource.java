package com.vitormarcal.desafio.features;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface  BaseResource<E, ID> {

    E buscar(ID id);

    List<E> listar();

    ResponseEntity<E> salvar(E e);

    ResponseEntity remover(ID id);

    ResponseEntity<E> editar(ID id, E e);
}
