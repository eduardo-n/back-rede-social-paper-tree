package com.projetotcc.papertree.controllers;

import com.projetotcc.papertree.dto.CurtidaDTO;
import com.projetotcc.papertree.dto.TrabalhoSalvoDTO;
import com.projetotcc.papertree.entities.Curtida;
import com.projetotcc.papertree.entities.TrabalhoSalvo;
import com.projetotcc.papertree.services.CurtidaService;
import com.projetotcc.papertree.services.TrabalhoSalvoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/trabalhosalvo")
public class TrabalhoSalvoController {

    @Autowired
    private TrabalhoSalvoService service;

    @GetMapping
    public ResponseEntity<List<TrabalhoSalvoDTO>> findAll(){
        List<TrabalhoSalvoDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/inserir")
    public ResponseEntity<TrabalhoSalvoDTO> inserirTrabalhoSalvo(@RequestBody TrabalhoSalvoDTO dto){
        dto = service.insert(dto);
        if(dto == null) {
            return ResponseEntity.badRequest().body(null);
        }
        else{
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(dto.getId()).toUri();
            return ResponseEntity.created(uri).body(dto);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deletarTrabalhoSalvo(@PathVariable Long id){
        TrabalhoSalvo trabalhoSalvo = service.buscarTrabalhoSalvo(id);
        service.delete(trabalhoSalvo);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<List<TrabalhoSalvoDTO>> encontrarTrabalhosSalvosPorUsuario(@PathVariable Long id){
        List<TrabalhoSalvoDTO> trabalhoSalvo = service.encontrarTrabalhosSalvosPorUsuario(id);
        return ResponseEntity.ok().body(trabalhoSalvo);
    }
}
