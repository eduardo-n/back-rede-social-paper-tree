package com.projetotcc.papertree.controllers;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetotcc.papertree.dto.WorkDTO;
import com.projetotcc.papertree.services.PostService;
import com.projetotcc.papertree.services.WorkService;

@RestController
@RequestMapping(value = "/works")
public class WorkController {

	private String pdfName;
	
    @Autowired
    private WorkService service;
    
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<WorkDTO>> findAll(){
        List<WorkDTO> workList = service.findAll();
        return ResponseEntity.ok().body(workList);
    }

    @PostMapping("/insert")
    public ResponseEntity<WorkDTO> insert(@RequestBody WorkDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        pdfName = dto.getId().toString();
        return ResponseEntity.created(uri).body(dto);
    }
    
    @PostMapping("/pdf")
    public ResponseEntity<String> uploadPdf(@RequestParam("file") MultipartFile file){
    	var path = "../../frontend-paper-tree-v2/frontend/src/assets/trabalhos-inseridos";
    	File f = new File(path);
    	
    	if (!f.exists()) {
    		boolean dir = f.mkdirs();
    		if(!dir) {
    			return new ResponseEntity<>( "{\"mensagem\": \"Erro ao criar diretorio\"}",HttpStatus.BAD_REQUEST);
    		}	
    	}
    	
    	var completePath = path + "/" + pdfName + ".pdf";
    	
    	try {
    		Files.copy(file.getInputStream(), Path.of(completePath), StandardCopyOption.REPLACE_EXISTING);
    		return new ResponseEntity<>( "{\"mensagem\": \"Arquivo carregado com sucesso!\"}",HttpStatus.OK);
    	}catch (Exception e) {
    		return new ResponseEntity<>( "{\"mensagem\": \"Erro ao carregar arquivo\"}",HttpStatus.BAD_REQUEST);
    	}
    	
     }

    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile image){
        var path = "../../frontend-paper-tree-v2/frontend/src/assets/imagem-trabalho";
        File f = new File(path);

        if (!f.exists()) {
            boolean dir = f.mkdirs();
            if(!dir) {
                return new ResponseEntity<>( "{\"mensagem\": \"Erro ao criar diretorio\"}",HttpStatus.BAD_REQUEST);
            }
        }
        String[] type = Objects.requireNonNull(image.getContentType()).split("/");
        var completePath = path + "/" + pdfName + "." + type[1];

        try {
            Files.copy(image.getInputStream(), Path.of(completePath), StandardCopyOption.REPLACE_EXISTING);
            return new ResponseEntity<>( "{\"mensagem\": \"Arquivo carregado com sucesso!\"}",HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>( "{\"mensagem\": \"Erro ao carregar arquivo\"}",HttpStatus.BAD_REQUEST);
        }

    }
   
}