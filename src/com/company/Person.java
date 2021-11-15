package com.company;

public class Person implements Comparable {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Object otherObject) {
        Person andenPerson = (Person) otherObject;
        String voresFornavn = firstName;
        String andetFornavn = andenPerson.firstName;
        if (voresFornavn.compareTo(andetFornavn) <= 0) {
            return -1;
        } else return 1;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

}
