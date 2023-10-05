package br.com.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
