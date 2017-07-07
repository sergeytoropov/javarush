package com.javarush.test.level17.lesson10.bonus01;

import java.util.Date;

public class Person {
    private String name;
    private Sex sex;
    private Date birthDay;

    private boolean isDeleted = false;

    private Person(String name, Sex sex, Date birthDay) {
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
    }

    public static Person createMale(String name, Date birthDay){
        return new Person(name, Sex.MALE, birthDay);
    }

    public static Person createFemale(String name, Date birthDay){
        return new Person(name, Sex.FEMALE, birthDay);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return name.equals(person.name) && sex == person.sex && birthDay.equals(person.birthDay);
    }

    @Override
    public String toString() {
        return "name = " + name + ", sex = " + sex + ", birthDay = " + birthDay;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
