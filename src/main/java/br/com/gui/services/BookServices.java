package br.com.gui.services;

import br.com.gui.controllers.BookController;
import br.com.gui.controllers.PersonController;
import br.com.gui.dto.v1.BookDTO;
import br.com.gui.dto.v1.PersonDTO;
import br.com.gui.exception.RequiredObjectIsNullException;
import br.com.gui.exception.ResourceNotFoundException;
import br.com.gui.model.Book;
import br.com.gui.model.Person;
import br.com.gui.repositories.BookRepository;
import br.com.gui.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static br.com.gui.mapper.ObjectMapper.parseListObjects;
import static br.com.gui.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookServices {
    private Logger logger = Logger.getLogger(BookServices.class.getName());

    @Autowired
    BookRepository repo;

    public List<BookDTO> findAll() {
        logger.info("Finding all books!");
        var books = parseListObjects(repo.findAll(), BookDTO.class);
        books.forEach(this::addHateoasLinks);
        return books;
    }

    public BookDTO findById(Long id) {
        logger.info("Finding one book!");
        var entity = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        var dto = parseObject(entity, BookDTO.class);
        addHateoasLinks(dto);
        return dto;
    }


    public BookDTO create(BookDTO book) {
        if(book == null) throw new RequiredObjectIsNullException();

        logger.info("Creating one person!");
        var entity = parseObject(book, Book.class);
        var dto = parseObject(repo.save(entity), BookDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public BookDTO update(BookDTO book) {
        if(book == null) throw new RequiredObjectIsNullException();

        logger.info("Updating one book!");
        Book entity = repo.findById(book.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        var dto = parseObject(repo.save(entity), BookDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public void delete(Long id) {
        logger.info("Deleting one book!");

        Book entity = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        repo.delete(entity);
    }

    private void addHateoasLinks(BookDTO dto) {
        dto.add(linkTo(methodOn(BookController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
        dto.add(linkTo(methodOn(BookController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(BookController.class).update(dto)).withRel("update").withType("PUT"));
    }

}
