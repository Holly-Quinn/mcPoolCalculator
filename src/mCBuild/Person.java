//package name
package mCBuild;

//imports the scanner
import java.util.Scanner;

//sets up a new class called person
public class Person {

    //private variables - used with getters/setters
    private String usrFirstName = "New";
    private String usrLastName = "User";

    //Getter for first name
    public String getFirstName () {

        return usrFirstName;

    }

    //Setter for first name
    public void setFirstName () {

        //sets up a new scanner object and then gets the user to enter a value for first name
        Scanner sc = new Scanner (System.in);
        System.out.println("Please Enter your First Name : ");
        String firstName = sc.nextLine();
        this.usrFirstName = firstName;

    }

    //Getter for last name
    public String getLastName () {

        return usrLastName;

    }

    //Setter for last name
    public void setLastName () {

        //sets up a new scanner object and then gets the user to enter a value for last name
        Scanner sc = new Scanner (System.in);
        System.out.println("Please Enter your Last Name : ");
        String lastName = sc.nextLine();
        this.usrLastName = lastName;

    }




}
