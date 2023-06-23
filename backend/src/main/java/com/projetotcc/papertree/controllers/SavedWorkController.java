package com.projetotcc.papertree.controllers;

import com.projetotcc.papertree.dto.PostDTO;
import com.projetotcc.papertree.dto.SavedWorkDTO;
import com.projetotcc.papertree.entities.SavedWork;
import com.projetotcc.papertree.services.SavedWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/saved/work")
public class SavedWorkController {

    @Autowired
    private SavedWorkService service;

    @GetMapping
    public ResponseEntity<List<SavedWorkDTO>> findAll(){
        List<SavedWorkDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/insert")
    public ResponseEntity<Object> insertSavedWork(@RequestBody SavedWorkDTO dto){
        dto = service.insert(dto);
        if(dto == null) {
            return ResponseEntity.badRequest().body("Erro ao inserir salvar trabalho!");
        }
        else{
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(dto.getId()).toUri();
            return ResponseEntity.created(uri).body(dto);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSavedWork(@PathVariable Long id){
        SavedWork savedWork = service.getSavedWork(id);
        service.delete(savedWork);
    }
}
