//CONTENTS
//Package
//Imports
//Main Class
//Main Method
//Main Menu Method - Displays the Main Menu
//Get Option Method - Gets an option from the user
//Enter Name Method - Allows the user to set their first and last name
//Shape Menu Method - Allows the user to select which shape they want to calculate
//Get Double Method - Method to get a double as user input - has error checking
//Calc Circle Method - Calculates the area/volume of a circular pool from user input. Outputs as an invoice and returns to menu on command.
//Calc Rectangle Method - Calculates the area/volume of a rectangular pool from user input. Outputs as an invoice and returns to menu on command.

package mCBuild;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.Math;


//main class - program runs in this class
public class Main {

    //main method - program runs from here
    public static void main(String[] args) {

        Person user = new Person();
        mainMenu(user);

    }

    //Method to run the main menu
    private static void mainMenu (Person user) {

        System.out.println("");
        System.out.println("  __  __  ___   ___      _ _    _ ");
        System.out.println(" |  \\/  |/ __| | _ )_  _(_) |__| |");
        System.out.println(" | |\\/| | (__  | _ \\ || | | / _` |");
        System.out.println(" |_|  |_|\\___| |___/\\_,_|_|_\\__,_| ");
        System.out.println("");
        System.out.println("Welcome to the Pool Calculator " +user.getFirstName() + " " + user.getLastName());
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

    //method to get a menu option from the user - has error checking
    private static int getOption () {

        boolean done = false;
        int option = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the option number below: ");


        while (done == false) {

            try {

                option = sc.nextInt();
                done = true;

            } catch (InputMismatchException e){

                System.out.println("Option not recognised - try again: ");
                sc.nextLine();

            }

        }

        return option;

    }

    //method to allow the user to enter their name
    private static void enterName (Person user) {

        user.setFirstName();
        user.setLastName();
        mainMenu(user);

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
                calcRectangle(user);

            } else if (option == 2) {

                valid = true;
                calcCircle(user);

            } else if (option == 3) {

                mainMenu(user);

            } else {

                System.out.println("Option not valid - Please try again");
                getOption();

            }

        }
    }

    //Method to get a double as user input - has error checking
    private static double getDouble () {

        double dub = 0;
        boolean done = false;
        Scanner sc = new Scanner(System.in);

        while (done == false) {

            try {

                dub = sc.nextDouble();
                done = true;

            } catch (InputMismatchException e){

                System.out.println("Input not valid - try again: ");
                sc.nextLine();

            }

        }
        return dub;

    }

    //Calculates the area/volume of a circular pool from user input. Outputs as an invoice and returns to menu on command.
    private static void calcCircle (Person user) {

        double circleRadius;
        double circleDepth;
        double circleArea;
        double circleVolume;

        System.out.println("Please enter the pool's radius (in meters and without units): ");
        circleRadius = getDouble();

        System.out.println("Please enter the pool's depth (in meters without units): ");
        circleDepth = getDouble();

        circleArea = ((3.14*((circleRadius)*(circleRadius)))+((2*(3.14*circleRadius))*circleDepth));

        circleVolume =(3.14*(circleRadius*circleRadius))*circleDepth;

        String sAlign1 = "| %1s %-1s %-1s \r\n";
        String sAlign2 = "| %1s %-1s %-1s %-1s %-1s \r\n";
        String sAlign3 = "| %1s %-1s %-1s %-1s \r\n";
        String sFiller = ("|                                             \n");

        DecimalFormat df = new DecimalFormat("0.000");

        System.out.format("+--------------------------------------------+\n");
        System.out.format(sAlign1,"Pool","Calculation","Output");
        System.out.format("+--------------------------------------------+\n");
        System.out.format(sAlign1,"User:",user.getFirstName(),user.getLastName());
        System.out.format("+--------------------------------------------+\n");
        System.out.format(sAlign1,"Pool","Shape:","Circular");
        System.out.format("+--------------------------------------------+\n");
        System.out.format(sAlign1,"Pool","Dimensions","");
        System.out.format(sFiller);
        System.out.format(sAlign1,"Radius:", df.format(circleRadius) ,"meters");
        System.out.format(sAlign1,"Depth:", df.format(circleDepth) ,"meters");
        System.out.format("+--------------------------------------------+\n");
        System.out.format(sAlign2,"Surface","Area:", df.format(circleArea), "meters", "squared");
        System.out.format(sFiller);
        System.out.format(sAlign3,"Volume:", df.format(circleVolume),"meters", "cubed");
        System.out.format("+--------------------------------------------+\n");
        System.out.format(sAlign3,"Press", "Enter" ,"to", "continue...");
        System.out.format("+--------------------------------------------+\n");

        try {
            System.in.read();
        }catch (Exception e){

        }

        mainMenu(user);

    }

    //Calculates the area/volume of a rectangular pool from user input. Outputs as an invoice and returns to menu on command.
    private static void calcRectangle (Person user) {

        Double rectangleLength;
        Double rectangleWidth;
        Double rectangleShallowDepth;
        Double rectangleDeepDepth;
        Double rectangleTotalArea;
        Double rectangleVolume;

        System.out.println("Please enter the pool's Length (in meters and without units): ");
        rectangleLength = getDouble();

        System.out.println("Please enter the pool's Width (in meters and without units): ");
        rectangleWidth = getDouble();

        System.out.println("Please enter the pool's Shallow End Depth (in meters and without units): ");
        rectangleShallowDepth = getDouble();

        System.out.println("Please enter the pool's Deep End Depth (in meters and without units): ");
        rectangleDeepDepth = getDouble();

        rectangleTotalArea = ((rectangleLength*rectangleShallowDepth)*2) + ((rectangleWidth*rectangleShallowDepth)*2) + (rectangleLength*(rectangleDeepDepth-rectangleShallowDepth)) + (rectangleWidth*(Math.sqrt(((rectangleDeepDepth-rectangleShallowDepth)*(rectangleDeepDepth - rectangleShallowDepth)) + (rectangleLength*rectangleLength))));

        rectangleVolume = (rectangleLength*rectangleWidth*(rectangleDeepDepth + rectangleShallowDepth)) /2;

        String sAlign1 = "| %1s %-1s %-1s \r\n";
        String sAlign2 = "| %1s %-1s %-1s %-1s %-1s \r\n";
        String sAlign3 = "| %1s %-1s %-1s %-1s \r\n";
        String sFiller = ("|                                             \n");

        DecimalFormat df = new DecimalFormat("0.000");

        System.out.format("+--------------------------------------------+\n");
        System.out.format(sAlign1,"Pool","Calculation","Output");
        System.out.format("+--------------------------------------------+\n");
        System.out.format(sAlign1,"User:",user.getFirstName(),user.getLastName());
        System.out.format("+--------------------------------------------+\n");
        System.out.format(sAlign1,"Pool","Shape:","Rectangular");
        System.out.format("+--------------------------------------------+\n");
        System.out.format(sAlign1,"Pool","Dimensions","");
        System.out.format(sFiller);
        System.out.format(sAlign1,"Width:", df.format(rectangleWidth) ,"meters");
        System.out.format(sAlign1,"Length:", df.format(rectangleLength) ,"meters");
        System.out.format(sAlign1,"Depth (Shallow End):", df.format(rectangleShallowDepth) ,"meters");
        System.out.format(sAlign1,"Length (Deep End):", df.format(rectangleDeepDepth) ,"meters");
        System.out.format("+--------------------------------------------+\n");
        System.out.format(sAlign2,"Surface","Area:", df.format(rectangleTotalArea), "meters", "squared");
        System.out.format(sFiller);
        System.out.format(sAlign3,"Volume:", df.format(rectangleVolume),"meters", "cubed");
        System.out.format("+--------------------------------------------+\n");
        System.out.format(sAlign3,"Press", "Enter" ,"to", "continue...");
        System.out.format("+--------------------------------------------+\n");

        try {
            System.in.read();
        }catch (Exception e){

        }

        mainMenu(user);

    }

    }
