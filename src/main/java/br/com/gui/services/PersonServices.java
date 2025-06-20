package br.com.gui.services;

import br.com.gui.exception.ResourceNotFoundException;
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

    public Person findById(Long id) {
        logger.info("Finding one person!");
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
    }

    public List<Person> findAll() {
        logger.info("Finding all persons!");
        return repo.findAll();
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return repo.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one person!");
        Person entity = repo.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repo.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        Person entity = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        repo.delete(entity);
    }

}
