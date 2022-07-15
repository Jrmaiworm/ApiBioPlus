package br.com.biomob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biomob.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
