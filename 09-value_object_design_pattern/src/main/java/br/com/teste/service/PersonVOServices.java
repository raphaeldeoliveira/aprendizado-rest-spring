package br.com.teste.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.data.vo.v1.PersonVO;
import br.com.teste.exceptions.ResourceNotFoundException;
import br.com.teste.repositories.PersonVORepository;

@Service
public class PersonVOServices {

	private Logger logger = Logger.getLogger(PersonVOServices.class.getName());
	
	@Autowired
	PersonVORepository repository;
	
	public List<PersonVO> findAll() {
		logger.info("Finding all people");

		return repository.findAll();
	}
	
	public PersonVO findById(Long id) {
		logger.info("Finding one PersonVO!");
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}
	
	public PersonVO create(PersonVO personVO) {
		logger.info("Creating one PersonVOVO!");
		return repository.save(personVO);
	}
	
	public PersonVO update(PersonVO personVO) {
		logger.info("Updating one PersonVO!");
		
		// primeiro recuperamos o PersonVO depois atualizamos os dados e salvamos
		// assim não sobrescrevemos o objeto
		var entity = repository.findById(personVO.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(personVO.getFirstName());
		entity.setLastName(personVO.getLastName());
		entity.setAddress(personVO.getAddress());
		entity.setGender(personVO.getGender());
		
		return repository.save(personVO);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one PersonVO!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		repository.delete(entity);
	}
	
}
