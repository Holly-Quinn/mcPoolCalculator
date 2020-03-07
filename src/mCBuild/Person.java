package mCBuild;

import java.util.Scanner;

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

        Scanner sc = new Scanner (System.in);
        System.out.println("Please Enter your Last Name : ");
        String lastName = sc.nextLine();
        this.usrLastName = lastName;

    }




}
