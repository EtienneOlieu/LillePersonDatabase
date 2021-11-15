package com.company;

import java.util.ArrayList;
import java.util.Collections;

//AKA applikationen
public class LittlePersonDataBase {

    UserInterface ui = new UserInterface();
    ArrayList<Person> personList = new ArrayList<>();

    public void start() {
        ui.welcomeMessage();
        loadStockLittlePeople();

        boolean goAgain = true;
        while (goAgain) {
            ui.showMenu();
            switch (ui.userString()) {
                case "1" -> {
                    Collections.sort(personList);
                    ui.seeListOfPersons(personList);
                }
                case "2" -> ui.statusOutput(createPerson());
                case "3" -> {
                    ui.removePersonMessage();
                    Collections.sort(personList);
                    ui.seeListOfPersons(personList);
                    ui.statusOutput(removePerson(ui.userString()));
                }
                case "0" -> {
                    ui.exitMessage();
                    goAgain = false;
                }
                default -> ui.statusOutput(StatusMessage.BADINPUT);
            }
        }
    }

    private StatusMessage removePerson(String userInput) {
        int littlePersonChoice = Integer.parseInt(userInput);
        try {
            personList.remove(littlePersonChoice - 1);
        } catch (IndexOutOfBoundsException e) {
            ui.statusOutput(StatusMessage.NOTFOUND);
        }
        return StatusMessage.OK;
    }

    public StatusMessage createPerson() {
        ui.firstName();
        String firstName = ui.userString();
        ui.lastName();
        String lastName = ui.userString();
        Person person = new Person(firstName, lastName);
        personList.add(person);
        ui.youHaveCreated(person);

        return StatusMessage.OK;
    }

    public void loadStockLittlePeople() {
        personList.add(new Person("Warwick", "Davis"));
        personList.add(new Person("Kenny", "Baker"));
        personList.add(new Person("Verne", "troyer"));
        personList.add(new Person("Meredith", "Eaton"));
        personList.add(new Person("Peter", "Dinklage"));
    }
}
