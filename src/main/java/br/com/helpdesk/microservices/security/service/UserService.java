package br.com.helpdesk.microservices.security.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.helpdesk.microservices.security.dto.NewUserDTO;
import br.com.helpdesk.microservices.security.model.Role;
import br.com.helpdesk.microservices.security.model.User;
import br.com.helpdesk.microservices.security.repository.RoleRepository;
import br.com.helpdesk.microservices.security.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder passwordEnconder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public User createUser (User user) {
		user.setId(null);
		return userRepository.save(user);
	}
	
	public User findByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}
	
	public User fromDTO (NewUserDTO newUserDTO) {
		List<Role> roles = roleRepository.findAllById(newUserDTO.getRoleIds());
		User user = new User(null, newUserDTO.getUsername(), passwordEnconder.encode(newUserDTO.getPassword()), newUserDTO.getEmail(), newUserDTO.getFullName(), true, true, true, true, roles);
		return user;
	}
}
