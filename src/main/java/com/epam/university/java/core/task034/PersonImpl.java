package com.epam.university.java.core.task034;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect
public class PersonImpl implements Person {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;

    @XmlElement(name = "first-name")
    @JsonProperty("firstName")
    private String firstName;

    @XmlElement(name = "last-name")
    @JsonProperty("lastName")
    private String lastName;

    @XmlElementWrapper(name = "person-phones")
    @XmlElements({@XmlElement(type = PhoneNumberImpl.class, name = "person-phone")})
    @SerializedName("phones")
    @JsonProperty("phones")
    private Collection<PhoneNumber> phoneNumbers;

    public PersonImpl() {}

    /**
     * Parameterized constructor.
     * @param id id.
     * @param firstName firstName.
     * @param lastName lastName.
     * @param phoneNumbers phoneNumbers.
     */
    @JsonCreator
    public PersonImpl(@JsonProperty(value = "id") int id,
                      @JsonProperty(value = "firstName") String firstName,
                      @JsonProperty(value = "lastName") String lastName,
                      @JsonProperty(value = "phones") Collection<PhoneNumberImpl> phoneNumbers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = new ArrayList<>(phoneNumbers);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {

        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Collection<PhoneNumber> getPhoneNumbers() {

        return phoneNumbers;
    }

    @Override
    public void setPhoneNumbers(Collection<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
