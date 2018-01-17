package com.vitormarcal.desafio.features;


import java.util.List;

public interface BaseService<E, ID> {

    E buscar(ID id);

    List<E> listar();

    E salvar(E e);

    void remover(ID id);

    E editar(ID id, E e);
}
