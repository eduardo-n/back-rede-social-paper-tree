package com.projetotcc.papertree.services;

import java.util.List;
import java.util.stream.Collectors;

import com.projetotcc.papertree.entities.Curtida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.PostagemDTO;
import com.projetotcc.papertree.dto.TrabalhoDTO;
import com.projetotcc.papertree.dto.UsuarioDTO;
import com.projetotcc.papertree.entities.Postagem;
import com.projetotcc.papertree.entities.Trabalho;
import com.projetotcc.papertree.entities.Usuario;
import com.projetotcc.papertree.repositories.PostagemRepository;

@Service
public class PostagemService {

	@Autowired
	private PostagemRepository repository;
	
	@Transactional
	public List<PostagemDTO> findAll(){
		List<Postagem> list = repository.findAllPostagem();
		return list.stream().map(x -> new PostagemDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public List<PostagemDTO> findPostByUser(Long id){
		List<Postagem> list = repository.findPostByUser(id);
		return list.stream().map(x -> new PostagemDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
    public PostagemDTO insert(Trabalho trabalho){

        Postagem postagem = new Postagem(trabalho);

        postagem = repository.save(postagem);
        return new PostagemDTO(postagem);

    }

	@Transactional
	public PostagemDTO updateLike(Long idPostagem, Curtida curtida){

		Postagem postagem = repository.getById(idPostagem);
		postagem = repository.save(postagem);
		return new PostagemDTO(postagem);

	}
}
