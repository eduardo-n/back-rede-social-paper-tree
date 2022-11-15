package com.projetotcc.papertree.services;

import com.projetotcc.papertree.dto.TrabalhoSalvoDTO;
import com.projetotcc.papertree.entities.TrabalhoSalvo;
import com.projetotcc.papertree.repositories.TrabalhoSalvoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrabalhoSalvoService {

    @Autowired
    TrabalhoSalvoRepository repository;

    @Autowired
    private PostagemService postagemService;

    @Transactional
    public List<TrabalhoSalvoDTO> findAll(){
        List<TrabalhoSalvo> list = repository.findAll();
        return list.stream().map(TrabalhoSalvoDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public TrabalhoSalvoDTO insert(TrabalhoSalvoDTO entity){
        TrabalhoSalvo trabalhoSalvo = new TrabalhoSalvo(null, entity.getAutor(), entity.getPostagem());

        trabalhoSalvo = repository.save(trabalhoSalvo);
        return new TrabalhoSalvoDTO(trabalhoSalvo);
    }

    @Transactional
    public void delete (TrabalhoSalvo trabalhoSalvo){
        repository.delete(trabalhoSalvo);
    }

    @Transactional
    public TrabalhoSalvo buscarTrabalhoSalvo(Long id){
        return repository.buscarTrabalhoSalvo(id);
    }

    @Transactional
    public List<TrabalhoSalvoDTO> encontrarTrabalhosSalvosPorUsuario(Long id){
        List<TrabalhoSalvo> list = repository.buscarTrabalhosSalvosPorUsuario(id);
        return list.stream().map(TrabalhoSalvoDTO::new).collect(Collectors.toList());
    }
}
