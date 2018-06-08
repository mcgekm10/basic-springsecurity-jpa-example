package io.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.springsecurity.domain.Role;

public interface RoleRepository extends JpaRepository<Role, String>{

}
