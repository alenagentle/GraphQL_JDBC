package com.vtb.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.vtb.graphql.dao.PersonDAO;
import com.vtb.graphql.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMutation implements GraphQLMutationResolver {

    private final PersonDAO personDAO;

    public Person createPerson(final String age, final String firstName, final String lastName) {
        Person person = new Person();
        person.setAge(age);
        person.setFirstName(firstName);
        person.setLastName(lastName);

        personDAO.createPerson(person);
        return person;
    }

    public Person updatePerson(final Long id, final String age, final String firstName, final String lastName) {
        Person person = personDAO.getPersonById(id);
        person.setAge(age);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        personDAO.updatePerson(person);
        return person;
    }

    public Person deletePerson(final Long id) {
        Person person = personDAO.getPersonById(id);
        personDAO.deletePerson(person);
        return person;
    }

}
