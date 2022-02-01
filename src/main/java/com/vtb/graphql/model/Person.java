package com.vtb.graphql.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Person {
    private Long id;
    private String age;
    private String firstName;
    private String lastName;
}
