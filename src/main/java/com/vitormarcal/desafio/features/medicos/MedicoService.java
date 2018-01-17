package com.vitormarcal.desafio.features.medicos;

import com.vitormarcal.desafio.features.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService implements BaseService<Medico, String> {


    private final MedicoRepository medicoRepository;

    @Autowired
    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public Medico buscar(String id) {
        Optional<Medico> medicoOptional = Optional.ofNullable(medicoRepository.findOne(id));
        return medicoOptional.orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Override
    public List<Medico> listar() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico salvar(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public void remover(String id) {
        medicoRepository.delete(id);
    }

    @Override
    public Medico editar(String id, Medico medico) {
        Medico medicoBanco = buscar(id);
        BeanUtils.copyProperties(medico, medicoBanco, "id", "createdDate");
        return medicoRepository.save(medicoBanco);
    }
}
