package br.com.helpdesk.microservices.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.helpdesk.microservices.security.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
