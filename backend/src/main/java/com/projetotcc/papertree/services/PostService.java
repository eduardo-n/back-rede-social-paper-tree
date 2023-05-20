package com.projetotcc.papertree.services;

import java.util.List;
import java.util.stream.Collectors;

import com.projetotcc.papertree.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.PostDTO;
import com.projetotcc.papertree.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	@Transactional
	public List<PostDTO> findAll(){
		List<Post> list = repository.findAllPostagem();
		return list.stream().map(PostDTO::new).collect(Collectors.toList());
	}

	@Transactional
	public List<PostDTO> findPostByUserId(Long id){
		List<Post> list = repository.getPostByUserId(id);
		return list.stream().map(PostDTO::new).collect(Collectors.toList());
	}

	@Transactional
	public List<PostDTO> getSavedPostByUserId(Long id){
		List<Post> list = repository.getSavedPostByUserId(id);
		return list.stream().map(PostDTO::new).collect(Collectors.toList());
	}
	
	@Transactional
    public PostDTO insert(Work work){
        Post post = new Post(work);

        post = repository.save(post);
        return new PostDTO(post);
    }

	@Transactional
	public PostDTO updateLike(Long idPost, Like like){
		Post post = repository.getById(idPost);

		post = repository.save(post);
		return new PostDTO(post);
	}

	@Transactional
	public PostDTO updateSavedWork(Long idPost, SavedWork savedWork){
		Post post = repository.getById(idPost);

		post = repository.save(post);
		return new PostDTO(post);
	}
}
