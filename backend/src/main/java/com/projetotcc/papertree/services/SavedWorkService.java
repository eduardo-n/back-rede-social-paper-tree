package com.projetotcc.papertree.services;

import com.projetotcc.papertree.dto.SavedWorkDTO;
import com.projetotcc.papertree.entities.SavedWork;
import com.projetotcc.papertree.repositories.SavedWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SavedWorkService {

    @Autowired
    SavedWorkRepository repository;

    @Autowired
    private PostService postService;

    @Transactional
    public List<SavedWorkDTO> findAll(){
        List<SavedWork> list = repository.findAll();
        return list.stream().map(SavedWorkDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public SavedWorkDTO insert(SavedWorkDTO entity){
        SavedWork savedWork = new SavedWork(null, entity.getAuthor(), entity.getPost());

        savedWork = repository.save(savedWork);
        return new SavedWorkDTO(savedWork);
    }

    @Transactional
    public void delete (SavedWork savedWork){
        repository.delete(savedWork);
    }

    @Transactional
    public SavedWork getSavedWork(Long id){
        return repository.getSavedWork(id);
    }
}
