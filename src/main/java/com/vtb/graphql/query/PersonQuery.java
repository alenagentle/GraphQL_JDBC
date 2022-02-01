package com.vtb.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.vtb.graphql.dao.PersonDAO;
import com.vtb.graphql.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonQuery implements GraphQLQueryResolver {

    private final PersonDAO personDAO;

    public List<Person> getPersons(final int count) {
        return this.personDAO.getAllPersons()
                .stream()
                .limit(count)
                .collect(Collectors.toList());
    }

    public Person getPerson(final Long id) {
        return this.personDAO.getPersonById(id);
    }

}
