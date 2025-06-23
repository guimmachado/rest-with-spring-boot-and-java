package br.com.gui.unitetests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.gui.model.Person;

public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }
    
    public br.com.gui.dto.PersonDTO mockDTO() {
        return mockDTO(0);
    }
    
    public List<Person> mockEntityList() {
        List<Person> personDTOS = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            personDTOS.add(mockEntity(i));
        }
        return personDTOS;
    }

    public List<br.com.gui.dto.PersonDTO> mockDTOList() {
        List<br.com.gui.dto.PersonDTO> personDTOS = new ArrayList<>();
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

    public br.com.gui.dto.PersonDTO mockDTO(Integer number) {
        br.com.gui.dto.PersonDTO personDTO = new br.com.gui.dto.PersonDTO();
        personDTO.setAddress("Address Test" + number);
        personDTO.setFirstName("First Name Test" + number);
        personDTO.setGender(((number % 2)==0) ? "Male" : "Female");
        personDTO.setId(number.longValue());
        personDTO.setLastName("Last Name Test" + number);
        return personDTO;
    }

}