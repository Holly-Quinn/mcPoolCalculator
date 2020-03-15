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


//Package name
package mCBuild;

//Imports - pre-build classes that can be imported when required
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.Math;


//main class - program runs in this class
public class Main {

    //main method - program runs from here
    public static void main(String[] args) {

        //Sets up a new object from the class person and calls it user - note that most methods take it in as a parameter so it is within scope.
        Person user = new Person();
        //Calls the mainMenu method with the parameter of user (the person object set up above)
        mainMenu(user);

    }

    //Method to run the main menu
    private static void mainMenu (Person user) {

        //Prints the logo and the menu to the console
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

        //creates an integer variable called option and sets it equal to the return of getOption. Doing so calls the method getOption.
        int option = getOption();
        //creates a boolean variable called valid
        boolean valid = false;

        //while loop - loops the code inside until the condition is met. In this case, the checking of the menu option until the user selects a valid option.
        while (valid == false) {

            //if statement - flow control that runs code based upon conditions. This if statement checks the value of option and runs code based upon it.
            if (option == 1) {

                //Valid option, runs the enterName method
                valid = true;
                enterName(user);

            } else if (option == 2) {

                //Valid option - runs the shapeMenu method
                valid = true;
                shapeMenu(user);

            } else if (option == 3) {

                //Valid option - exits the program
                System.exit(0);

            } else {

                //This option runs if none of the above 3 options are selected. It then re-runs the getOption method so the user can select again
                System.out.println("Option not valid - Please try again");
                getOption();

            }

        }

    }

    //method to get a menu option from the user - has error checking
    private static int getOption () {

        //sets up the variable condition for the while loop, a variable called option to be returned and sets up the scanner.
        boolean done = false;
        int option = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the option number below: ");

        //While loop to loop until the user enters a valid option in case an InputMismatchException is thrown
        while (done == false) {

            //Try/catch - runs the code in try, and if the error type in the catch is thrown, then it will run the code in catch.
            try {

                //gets user input and stops loop
                option = sc.nextInt();
                done = true;

            } catch (InputMismatchException e){

                //Prints to the console to feedback to the user then moves the scanner to the next line to prevent infinite loop.
                System.out.println("Option not recognised - try again: ");
                sc.nextLine();

            }

        }

        //returns the value of option
        return option;

    }

    //method to allow the user to enter their name
    private static void enterName (Person user) {

        //runs the methods in the Person class for the object user to allow the user to enter their name. Returns to the menu when complete.
        user.setFirstName();
        user.setLastName();
        mainMenu(user);

    }

    //Method to display the shape selecting menu
    private static void shapeMenu (Person user) {

        //Prints logo and menu to the console
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

        //sets up variables for the while loop and if else
        int option = getOption();
        boolean valid = false;

        //While loop to loop lines of code until a valid option is selected
        while (valid == false) {

            //if else statement to check menu option value
            if (option == 1) {

                //valid option - breaks the loop - runs the calcRectangle method
                valid = true;
                calcRectangle(user);

            } else if (option == 2) {

                //valid option - breaks the loop - runs the calcCircle method
                valid = true;
                calcCircle(user);

            } else if (option == 3) {

                //valid option - breaks the loop - returns to the main menu
                mainMenu(user);

            } else {

                //This option runs if none of the above 3 options are selected. It then re-runs the getOption method so the user can select again
                System.out.println("Option not valid - Please try again");
                getOption();

            }

        }
    }

    //Method to get a double as user input - has error checking
    private static double getDouble () {

        //Sets up the variables and the scanner object
        double dub = 0;
        boolean done = false;
        Scanner sc = new Scanner(System.in);

        //while loop to loop until an exception is not thrown
        while (done == false) {

            //try catch to check for InputMismatchException
            try {

                //gets a double as user input and breaks loop
                dub = sc.nextDouble();
                done = true;

            } catch (InputMismatchException e){

                //Tells the user of the error and moves the scanner to the next line to prevent infinite loop
                System.out.println("Input not valid - try again: ");
                sc.nextLine();

            }

        }
        // returns the value of dub
        return dub;

    }

    //Calculates the area/volume of a circular pool from user input. Outputs as an invoice and returns to menu on command.
    private static void calcCircle (Person user) {

        //sets up the variables for calculation
        double circleRadius;
        double circleDepth;
        double circleArea;
        double circleVolume;

        //gets the values for radius and depth from the user using the getDouble method
        System.out.println("Please enter the pool's radius (in meters and without units): ");
        circleRadius = getDouble();

        System.out.println("Please enter the pool's depth (in meters without units): ");
        circleDepth = getDouble();

        //calculates the are and volume
        circleArea = ((3.14*((circleRadius)*(circleRadius)))+((2*(3.14*circleRadius))*circleDepth));

        circleVolume =(3.14*(circleRadius*circleRadius))*circleDepth;

        //sets up the variables for outputting the invoice
        String sAlign1 = "| %1s %-1s %-1s \r\n";
        String sAlign2 = "| %1s %-1s %-1s %-1s %-1s \r\n";
        String sAlign3 = "| %1s %-1s %-1s %-1s \r\n";
        String sFiller = ("|                                             \n");
        String sLine = ("+--------------------------------------------+\n");

        //creates a new decimal format object - this is used to set the number of decimal places to 3
        DecimalFormat df = new DecimalFormat("0.000");

        //outputs the results as an invoice
        System.out.format(sLine);
        System.out.format(sAlign1,"Pool","Calculation","Output");
        System.out.format(sLine);
        System.out.format(sAlign1,"User:",user.getFirstName(),user.getLastName());
        System.out.format(sLine);
        System.out.format(sAlign1,"Pool","Shape:","Circular");
        System.out.format(sLine);
        System.out.format(sAlign1,"Pool","Dimensions","");
        System.out.format(sFiller);
        System.out.format(sAlign1,"Radius:", df.format(circleRadius) ,"meters");
        System.out.format(sAlign1,"Depth:", df.format(circleDepth) ,"meters");
        System.out.format(sLine);
        System.out.format(sAlign2,"Surface","Area:", df.format(circleArea), "meters", "squared");
        System.out.format(sFiller);
        System.out.format(sAlign3,"Volume:", df.format(circleVolume),"meters", "cubed");
        System.out.format(sLine);
        System.out.format(sAlign3,"Press", "Enter" ,"to", "continue...");
        System.out.format(sLine);

        //waits for user to press enter
        try {
            System.in.read();
        }catch (Exception e){

        }

        //returns to the main menu
        mainMenu(user);

    }

    //Calculates the area/volume of a rectangular pool from user input. Outputs as an invoice and returns to menu on command.
    private static void calcRectangle (Person user) {

        //sets up the values for calculation
        Double rectangleLength;
        Double rectangleWidth;
        Double rectangleShallowDepth;
        Double rectangleDeepDepth;
        Double rectangleTotalArea;
        Double rectangleVolume;

        //gets the values from the user for length width and shallow/deep end depth
        System.out.println("Please enter the pool's Length (in meters and without units): ");
        rectangleLength = getDouble();

        System.out.println("Please enter the pool's Width (in meters and without units): ");
        rectangleWidth = getDouble();

        System.out.println("Please enter the pool's Shallow End Depth (in meters and without units): ");
        rectangleShallowDepth = getDouble();

        System.out.println("Please enter the pool's Deep End Depth (in meters and without units): ");
        rectangleDeepDepth = getDouble();

        //calculates the are and volume
        rectangleTotalArea = ((rectangleLength*rectangleShallowDepth)*2) + ((rectangleWidth*rectangleShallowDepth)*2) + (rectangleLength*(rectangleDeepDepth-rectangleShallowDepth)) + (rectangleWidth*(Math.sqrt(((rectangleDeepDepth-rectangleShallowDepth)*(rectangleDeepDepth - rectangleShallowDepth)) + (rectangleLength*rectangleLength))));

        rectangleVolume = (rectangleLength*rectangleWidth*(rectangleDeepDepth + rectangleShallowDepth)) /2;

        //sets up the string variables for the invoice
        String sAlign1 = "| %1s %-1s %-1s \r\n";
        String sAlign2 = "| %1s %-1s %-1s %-1s %-1s \r\n";
        String sAlign3 = "| %1s %-1s %-1s %-1s \r\n";
        String sFiller = ("|                                             \n");
        String sLine = ("+--------------------------------------------+\n");

        //creates a new decimal format object - this is used to set the number of decimal places to 3
        DecimalFormat df = new DecimalFormat("0.000");

        //outputs the results as an invoice
        System.out.format(sLine);
        System.out.format(sAlign1,"Pool","Calculation","Output");
        System.out.format(sLine);
        System.out.format(sAlign1,"User:",user.getFirstName(),user.getLastName());
        System.out.format(sLine);
        System.out.format(sAlign1,"Pool","Shape:","Rectangular");
        System.out.format(sLine);
        System.out.format(sAlign1,"Pool","Dimensions","");
        System.out.format(sFiller);
        System.out.format(sAlign1,"Width:", df.format(rectangleWidth) ,"meters");
        System.out.format(sAlign1,"Length:", df.format(rectangleLength) ,"meters");
        System.out.format(sAlign1,"Depth (Shallow End):", df.format(rectangleShallowDepth) ,"meters");
        System.out.format(sAlign1,"Length (Deep End):", df.format(rectangleDeepDepth) ,"meters");
        System.out.format(sLine);
        System.out.format(sAlign2,"Surface","Area:", df.format(rectangleTotalArea), "meters", "squared");
        System.out.format(sFiller);
        System.out.format(sAlign3,"Volume:", df.format(rectangleVolume),"meters", "cubed");
        System.out.format(sLine);
        System.out.format(sAlign3,"Press", "Enter" ,"to", "continue...");
        System.out.format(sLine);

        //waits for user input
        try {
            System.in.read();
        }catch (Exception e){

        }

        //returns to the main menu
        mainMenu(user);

    }

    }
