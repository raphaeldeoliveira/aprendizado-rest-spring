package br.com.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.data.vo.v1.PersonVO;

public interface PersonVORepository extends JpaRepository<PersonVO, Long> {

}
