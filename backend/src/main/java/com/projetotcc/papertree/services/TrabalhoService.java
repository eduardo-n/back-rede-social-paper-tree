package com.projetotcc.papertree.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.TrabalhoDTO;
import com.projetotcc.papertree.dto.UsuarioDTO;
import com.projetotcc.papertree.entities.Trabalho;
import com.projetotcc.papertree.entities.Usuario;
import com.projetotcc.papertree.repositories.TrabalhoRepository;
import com.projetotcc.papertree.repositories.UsuarioRepository;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public List<TrabalhoDTO> findAll(){
        List<Trabalho> list = repository.findAll();
        return list.stream().map(x -> new TrabalhoDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public TrabalhoDTO insert(TrabalhoDTO dto){

        Trabalho trabalho = new Trabalho(null, dto.getTitulo(), dto.getArea(), dto.getDescricao(), dto.getAvaliacao());

        for(UsuarioDTO contribuidores : dto.getContribuidores()) {
            Usuario usuario = usuarioRepository.getOne(contribuidores.getId());
            trabalho.getContribuidores().add(usuario);
        }

        trabalho = repository.save(trabalho);
        return new TrabalhoDTO(trabalho);

    }
}