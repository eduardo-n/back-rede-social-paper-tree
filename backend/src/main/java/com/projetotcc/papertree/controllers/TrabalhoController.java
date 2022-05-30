package com.projetotcc.papertree.controllers;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

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

import com.projetotcc.papertree.dto.TrabalhoDTO;
import com.projetotcc.papertree.services.TrabalhoService;

@RestController
@RequestMapping(value = "/trabalhos")
public class TrabalhoController {

	private String nomePdf;
	
    @Autowired
    private TrabalhoService service;

    @GetMapping
    public ResponseEntity<List<TrabalhoDTO>> findAll(){

        /*
        TrabalhoDTO trabalhoDtoTeste = new TrabalhoDTO();
        Usuario usuarioTeste = new Usuario();

        usuarioTeste.setCpf("123456");
        usuarioTeste.setNome("Rachel Reis");
        usuarioTeste.setEmail("rachel@ufv.br");

        trabalhoDtoTeste.setOrientador(usuarioTeste);

        List<TrabalhoDTO> list = new ArrayList();
        list.add(trabalhoDtoTeste);
        list.add(trabalhoDtoTeste);
        list.add(trabalhoDtoTeste);
        */


        List<TrabalhoDTO> listTrabalho = service.findAll();
        return ResponseEntity.ok().body(listTrabalho);
    }

    @PostMapping("/inserir")
    public ResponseEntity<TrabalhoDTO> insert(@RequestBody TrabalhoDTO dto){
    	
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        nomePdf = dto.getId().toString();
        return ResponseEntity.created(uri).body(dto);

    }
    
    @PostMapping("/pdf")
    public ResponseEntity<String> uploadPdf(@RequestParam("file") MultipartFile file){
    	
    	var path = "C:/PaperTree/TCC";
    	File f = new File(path);  
    	
    	if (!f.exists()) {
    		boolean diretorio = f.mkdirs();
    		if(!diretorio) {
    			return new ResponseEntity<>( "{\"mensagem\": \"Erro ao criar diretorio\"}",HttpStatus.BAD_REQUEST);
    		}	
    	}
    	
    	var caminho = path + "/" + nomePdf + ".pdf";
    	
    	try {
    		Files.copy(file.getInputStream(), Path.of(caminho), StandardCopyOption.REPLACE_EXISTING);
    		return new ResponseEntity<>( "{\"mensagem\": \"Arquivo carregado com sucesso!\"}",HttpStatus.OK);
    	}catch (Exception e) {
    		return new ResponseEntity<>( "{\"mensagem\": \"Erro ao carregar arquivo\"}",HttpStatus.BAD_REQUEST);
    	}
    	
     }
    
    private String extrairExtensao(String nomeArquivo) {
    	int i = nomeArquivo.lastIndexOf(".");
    	return nomeArquivo.substring(i+1);
    }
    
   
}