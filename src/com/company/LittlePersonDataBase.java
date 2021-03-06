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
        StatusMessage statusMessage = null;
        try {
        int littlePersonChoice = Integer.parseInt(userInput);
            personList.remove(littlePersonChoice - 1);
            statusMessage = StatusMessage.OK;
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            statusMessage = StatusMessage.NOTFOUND;
        }
        return statusMessage;
    }

    public StatusMessage createPerson() {
        ui.firstNamePrompt();
        String firstName = ui.userString();
        ui.lastNamePrompt();
        String lastName = ui.userString();
        Person person = new Person(firstName, lastName);
        personList.add(person);
        ui.youHaveCreated(person);

        return StatusMessage.OK;
    }

    public void loadStockLittlePeople() {
        personList.add(new Person("Warwick", "Davis"));
        personList.add(new Person("Kenny", "Baker"));
        personList.add(new Person("Verne", "Troyer"));
        personList.add(new Person("Meredith", "Eaton"));
        personList.add(new Person("Peter", "Dinklage"));
    }
}
