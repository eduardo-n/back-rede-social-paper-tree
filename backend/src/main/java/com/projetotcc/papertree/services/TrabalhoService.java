package com.projetotcc.papertree.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.projetotcc.papertree.dto.TrabalhoDTO;
import com.projetotcc.papertree.dto.UsuarioDTO;
import com.projetotcc.papertree.entities.Trabalho;
import com.projetotcc.papertree.entities.Usuario;
import com.projetotcc.papertree.repositories.TrabalhoRepository;
import com.projetotcc.papertree.repositories.UsuarioRepository;

@Service
public class TrabalhoService {
	
	private final Path root = Paths.get("C:/PaperTree/TCC");

    @Autowired
    private TrabalhoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PostagemService postagemService;

    @Transactional
    public List<TrabalhoDTO> findAll(){
        List<Trabalho> list = repository.findAllTrabalho();
        return list.stream().map(x -> new TrabalhoDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public TrabalhoDTO insert(TrabalhoDTO dto){

        Trabalho trabalho = new Trabalho(null, dto.getTitulo(), dto.getArea(), dto.getDescricao(), dto.getAvaliacao(), dto.getDataCriacao());

        for(UsuarioDTO contribuidores : dto.getContribuidores()) {
            Usuario usuario = usuarioRepository.getOne(contribuidores.getId());
            trabalho.getContribuidores().add(usuario);
        }

        trabalho = repository.save(trabalho);
        postagemService.insert(trabalho);

        return new TrabalhoDTO(trabalho);

    }
    
    public Resource loadPdf(String filename) {
      try {
        Path file = root.resolve(filename);
        Resource resource = (Resource) new UrlResource(file.toUri());
        if (resource.exists() || resource.isReadable()) {
          return resource;
        } else {
          throw new RuntimeException("Could not read the file!");
        }
      } catch (MalformedURLException e) {
        throw new RuntimeException("Error: " + e.getMessage());
      }
    }
    
    public Stream<Path> loadAllPdf() {
        try {
          return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
          throw new RuntimeException("Could not load the files!");
        }
      }
}