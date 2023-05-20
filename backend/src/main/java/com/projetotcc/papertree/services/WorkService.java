package com.projetotcc.papertree.services;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.WorkDTO;
import com.projetotcc.papertree.dto.UserDTO;
import com.projetotcc.papertree.entities.Work;
import com.projetotcc.papertree.entities.User;
import com.projetotcc.papertree.repositories.WorkRepository;
import com.projetotcc.papertree.repositories.UserRepository;

@Service
public class WorkService {
	
	private final Path root = Paths.get("C:/PaperTree/TCC");

    @Autowired
    private WorkRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostService postService;

    @Transactional
    public List<WorkDTO> findAll(){
        List<Work> list = repository.getAllWork();
        return list.stream().map(WorkDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public WorkDTO insert(WorkDTO dto){

        Work work = new Work(null, dto.getTitle(), dto.getArea(), dto.getDescription(), dto.getRating(), dto.getCreationDate());

        for(UserDTO contributors : dto.getContributors()) {
            User user = userRepository.getById(contributors.getId());
            work.getContributors().add(user);
        }

        work = repository.save(work);
        postService.insert(work);

        return new WorkDTO(work);
    }
}