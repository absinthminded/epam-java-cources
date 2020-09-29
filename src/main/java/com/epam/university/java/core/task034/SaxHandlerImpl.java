package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

public class SaxHandlerImpl extends SaxHandler {

    private Person person;
    private String element;
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public Person getPerson() {
        return person;
    }

    @Override
    public void startDocument() throws SAXException {
        person = new PersonImpl();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("person")) {
            person.setId(Integer.parseInt(attributes.getValue("id")));
        }
        element = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (element.equals("first-name")) {
            person.setFirstName(new String(ch, start, length));
        }
        if (element.equals("last-name")) {
            person.setLastName(new String(ch, start, length));
        }
        if (element.equals("person-phone")) {
            phoneNumbers.add(new PhoneNumberImpl(new String(ch, start, length)));
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person-phones")) {
            person.setPhoneNumbers(phoneNumbers);
        }

        element = "";
    }
}
