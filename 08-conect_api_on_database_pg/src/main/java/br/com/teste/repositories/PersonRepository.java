package br.com.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
