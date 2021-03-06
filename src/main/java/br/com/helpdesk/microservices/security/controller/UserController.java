package br.com.helpdesk.microservices.security.controller;

import java.net.URI;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.helpdesk.microservices.security.dto.NewUserDTO;
import br.com.helpdesk.microservices.security.model.User;
import br.com.helpdesk.microservices.security.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	@PreAuthorize("hasAnyRole('role_admin')")
	public ResponseEntity<Void> createUser (@Valid @RequestBody NewUserDTO newUserDTO) {
		User user = userService.fromDTO(newUserDTO);
		userService.createUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/loadLoggedUser")
	public ResponseEntity<User> findByUsername (Principal loggedUser) {
		User user = userService.findByUsername(loggedUser.getName());
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/user")
	public Principal user (Principal user) {
		return user;
	}
}
