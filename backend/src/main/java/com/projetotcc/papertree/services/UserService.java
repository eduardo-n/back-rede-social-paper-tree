package com.projetotcc.papertree.services;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.UserDTO;
import com.projetotcc.papertree.entities.User;
import com.projetotcc.papertree.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional
	public List<UserDTO> findAll(){
		List<User> list = repository.findAll();
		return list.stream().map(UserDTO::new).collect(Collectors.toList());
	}
	
	@Transactional
	public  List<UserDTO> getUsersBySplitNameOrRegister(String string){
		List<User> list = repository.getUsersBySplitNameOrRegister(string.toUpperCase());
		
		return list.stream().map(UserDTO::new).collect(Collectors.toList());
	}
	
	@Transactional
	public UserDTO getUsersByEmailAndPassword(String email, String senha){
		UserDTO user = (UserDTO) repository.getUsersByEmailAndPassword(email, senha);
		
		if(Objects.isNull(user)) {
			return null;
		}
		return user;
	}
	
	@Transactional
	public UserDTO insert(UserDTO dto){
		
		User userEmail = new User();
		userEmail = repository.getUsersByEmail(dto.getEmail());
		if(userEmail == null) {
			User user = new User(null, dto.getName(), dto.getEmail(), dto.getCpf(), dto.getRegister(),
					dto.getCourse(), dto.getPassword(), dto.getAdmissionDate(),dto.getContributorType(), null);
			
			user = repository.save(user);
			return new UserDTO(user);
		}
		else {
			return null;
		}
	}

	@Transactional
	public Boolean updatePassword(String email, String password){

		User userEmail = repository.getUsersByEmail(email);
		if(userEmail != null) {
			repository.updateUserPasswordByEmail(password, userEmail.getEmail());
			return true;
		}
		else {
			return false;
		}

	}
}