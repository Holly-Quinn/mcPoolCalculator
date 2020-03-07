package mCBuild;

import java.util.*;

//CONTENTS
//

//main class - program runs in this class
public class Main {

    //main class - program runs from here
    public static void main(String[] args) {

        Person user = new Person();
        mainMenu("New", "User", user);

    }

    //Method to run the main menu
    private static void mainMenu (String usrFirstName, String usrLastName, Person user) {

        System.out.println("");
        System.out.println("  __  __  ___   ___      _ _    _ ");
        System.out.println(" |  \\/  |/ __| | _ )_  _(_) |__| |");
        System.out.println(" | |\\/| | (__  | _ \\ || | | / _` |");
        System.out.println(" |_|  |_|\\___| |___/\\_,_|_|_\\__,_| ");
        System.out.println("");
        System.out.println("Welcome to the Pool Calculator " +usrFirstName + " " + usrLastName);
        System.out.println("Please select an option:");
        System.out.println("");
        System.out.println("1) Enter your Name");
        System.out.println("2) Calculate pool dimensions");
        System.out.println("3) Exit");

        int option = getOption();
        boolean valid = false;

        while (valid == false) {

            if (option == 1) {

                valid = true;
                enterName(user);

            } else if (option == 2) {

                //System.out.println("Option 2 Selected");
                valid = true;
                shapeMenu(user);

            } else if (option == 3) {

                System.exit(0);

            } else {

                System.out.println("Option not valid - Please try again");
                getOption();

            }

        }

    }

    //method to get a menu option from the user
    private static int getOption () {

        int option;
        System.out.println("Enter your option: ");
        Scanner sc = new Scanner(System.in);
        option = sc.nextInt();
        return option;

    }

    //method to allow the user to enter their name
    private static void enterName (Person user) {

        user.setFirstName();
        user.setLastName();
        mainMenu(user.getFirstName(), user.getLastName(), user);

    }

    //Method to display the shape selecting menu
    private static void shapeMenu (Person user) {

        System.out.println("");
        System.out.println("  __  __  ___   ___      _ _    _ ");
        System.out.println(" |  \\/  |/ __| | _ )_  _(_) |__| |");
        System.out.println(" | |\\/| | (__  | _ \\ || | | / _` |");
        System.out.println(" |_|  |_|\\___| |___/\\_,_|_|_\\__,_| ");
        System.out.println("");
        System.out.println("What shape pool would you like to calculate?");
        System.out.println("");
        System.out.println("1) Rectangular");
        System.out.println("2) Circular");
        System.out.println("3) Cancel");

        int option = getOption();
        boolean valid = false;

        while (valid == false) {

            if (option == 1) {

                valid = true;
                System.out.println("You selected Rectangular");
                mainMenu(user.getFirstName(), user.getLastName(), user);

            } else if (option == 2) {

                System.out.println("Option 2 Selected");
                mainMenu(user.getFirstName(), user.getLastName(), user);

            } else if (option == 3) {

                mainMenu(user.getFirstName(), user.getLastName(), user);

            } else {

                System.out.println("Option not valid - Please try again");
                getOption();

            }

        }
    }

    }
