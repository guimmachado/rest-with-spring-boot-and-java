package br.com.gui.services;

import br.com.gui.dto.PersonDTO;
import br.com.gui.exception.ResourceNotFoundException;

import static br.com.gui.mapper.ObjectMapper.parseListObjects;
import static br.com.gui.mapper.ObjectMapper.parseObject;

import br.com.gui.model.Person;
import br.com.gui.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repo;

    public List<PersonDTO> findAll() {
        logger.info("Finding all persons!");
        return parseListObjects(repo.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one person!");
        var entity = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating one person!");
        var entity = parseObject(person, Person.class);
        return parseObject(repo.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating one person!");
        Person entity = repo.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repo.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        Person entity = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        repo.delete(entity);
    }

}
