package com.company;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);

    public String userString() {
        return sc.nextLine();

    }

    public void welcomeMessage() {
        System.out.println("Welcome to LPB, the premiere database for little people");
    }

    public void showMenu() {
        String menu = """
                -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                press '1' to see a list of available little people.
                press '2' to add a little person to our database.
                press '3' to remove a little person from our database. 
                press '0' to exit the LPB.
                -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                """;

        System.out.println(menu);
    }

    public void seeListOfPersons(List list) {
        int counter = 0;
        for (Object person : list) {
            counter++;
            System.out.println("[" + counter + "]" + " " + person);
        }
    }

    public void exitMessage() {
        String message = """
                Goodbye.
                -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                We hope that you have enjoyed your time with our little people here at LPB
                Remember to tell you friends about us.
                -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                """;

        System.out.println(message);
    }

    public void removePersonMessage() {
        String message = "Please press the number that corresponds to the little person you wish to remove";
        System.out.println(message);
    }

    public void firstNamePrompt() {
        System.out.println("Please type the first name of the little person you wish to add.");
    }

    public void lastNamePrompt() {
        System.out.println("Please type the last name of the little person you wish to add.");
    }

    public void youHaveCreated(Person person) {
        System.out.println("You have added " + person + " to the LPB");
    }

    public void statusOutput(StatusMessage statusMessage) {
        switch (statusMessage) {
            case OK -> System.out.println("Task completed successfully.");
            case NO -> System.out.println("Task failed.");
            case NOTFOUND -> System.out.println("The item you were looking for could not be found.");
            case ERROR -> System.out.println("An error has occured. Please try again");
            case BADINPUT -> System.out.println("Input was not registered.\nPlease type a valid input.");
        }
    }
}
