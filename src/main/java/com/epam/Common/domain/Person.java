package com.epam.Common.domain;

import java.util.Date;

/**
 * Created by Evgeny_Akulenko on 7/6/2016.
 */
public class Person {
    private String name;
    private String patronymic;
    private String surName;
    private Date birthDate;

    public Person() {

    }

    public Person(String name, String patronymic, String surName, Date birthDate) {
        this.name = name;
        this.patronymic = patronymic;
        this.surName = surName;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSurName() {
        return surName;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}
