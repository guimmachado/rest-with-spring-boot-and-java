package br.com.gui.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.gui.dto.v1.PersonDTO;
import br.com.gui.model.Person;

public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }
    
    public PersonDTO mockDTO() {
        return mockDTO(0);
    }
    
    public List<Person> mockEntityList() {
        List<Person> personDTOS = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            personDTOS.add(mockEntity(i));
        }
        return personDTOS;
    }

    public List<PersonDTO> mockDTOList() {
        List<PersonDTO> personDTOS = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            personDTOS.add(mockDTO(i));
        }
        return personDTOS;
    }
    
    public Person mockEntity(Integer number) {
        Person personDTO = new Person();
        personDTO.setAddress("Address Test" + number);
        personDTO.setFirstName("First Name Test" + number);
        personDTO.setGender(((number % 2)==0) ? "Male" : "Female");
        personDTO.setId(number.longValue());
        personDTO.setLastName("Last Name Test" + number);
        return personDTO;
    }

    public PersonDTO mockDTO(Integer number) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setAddress("Address Test" + number);
        personDTO.setFirstName("First Name Test" + number);
        personDTO.setGender(((number % 2)==0) ? "Male" : "Female");
        personDTO.setId(number.longValue());
        personDTO.setLastName("Last Name Test" + number);
        return personDTO;
    }

}