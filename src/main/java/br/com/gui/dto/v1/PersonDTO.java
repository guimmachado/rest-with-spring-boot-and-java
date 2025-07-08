package br.com.gui.dto.v1;

import br.com.gui.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonFilter("PersonFilter")
@XmlRootElement
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String firstName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phoneNumber;

    private String address;

    @JsonSerialize(using = GenderSerializer.class)
    private String gender;

    private Boolean enabled;

    private String sensitiveData;

    public PersonDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSensitiveData() {
        return sensitiveData;
    }

    public void setSensitiveData(String sensitiveData) {
        this.sensitiveData = sensitiveData;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonDTO personDTO)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getId(), personDTO.getId()) && Objects.equals(getFirstName(), personDTO.getFirstName()) && Objects.equals(getLastName(), personDTO.getLastName()) && Objects.equals(getPhoneNumber(), personDTO.getPhoneNumber()) && Objects.equals(getAddress(), personDTO.getAddress()) && Objects.equals(getGender(), personDTO.getGender()) && Objects.equals(getEnabled(), personDTO.getEnabled()) && Objects.equals(getSensitiveData(), personDTO.getSensitiveData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getFirstName(), getLastName(), getPhoneNumber(), getAddress(), getGender(), getEnabled(), getSensitiveData());
    }
}
