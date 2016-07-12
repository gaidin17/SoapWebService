package com.epam.Common.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Evgeny_Akulenko on 7/6/2016.
 */
@XmlRootElement
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public String getPatronymic() {
        return patronymic;
    }

    @XmlElement
    public String getSurName() {
        return surName;
    }

    @XmlElement
    public Date getBirthDate() {
        return birthDate;
    }
}
