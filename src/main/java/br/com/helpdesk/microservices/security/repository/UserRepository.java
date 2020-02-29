package br.com.helpdesk.microservices.security.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.helpdesk.microservices.security.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
}
