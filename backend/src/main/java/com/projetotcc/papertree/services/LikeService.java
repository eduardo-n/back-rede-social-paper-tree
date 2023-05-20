package com.projetotcc.papertree.services;

import java.util.List;
import java.util.stream.Collectors;

import com.projetotcc.papertree.entities.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.LikeDTO;
import com.projetotcc.papertree.repositories.LikeRepository;

@Service
public class LikeService {

	@Autowired
	private LikeRepository repository;

	@Autowired
	private PostService postService;
	
	@Transactional
	public List<LikeDTO> findAll(){
		List<Like> list = repository.findAll();
		return list.stream().map(LikeDTO::new).collect(Collectors.toList());
	}

	@Transactional
	public LikeDTO insert(LikeDTO entity){
		Like like = new Like(null, entity.getAuthor(), entity.getPost());

		like = repository.save(like);
		return new LikeDTO(like);
	}

	@Transactional
	public void delete (Like like){
		repository.delete(like);
	}

	@Transactional
	public Like getLikeById(Long id){
		return repository.getLikeById(id);
	}
}
