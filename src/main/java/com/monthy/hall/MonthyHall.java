package com.monthy.hall;

import com.monthy.hall.implementations.BoxSelection;

import java.util.Random;
import java.util.Scanner;

public class MonthyHall {


    public static void main(String args[]){

        mothlyHallStart();

    }

    public static String mothlyHallStart() {
        String choice;
        Scanner sc = new Scanner(System.in);
        String result=null;
        do {
            BoxSelection boxSelection = new BoxSelection();

            System.out.println("Welcome to Star TV Show");
            Random random = new Random();
            int hostBox, contenstantBox,openBox=0,remainingBox=0;

            hostBox = random.nextInt(3) + 1;
            System.out.println("Which box do you want to select from 1,2 and 3 ");
            contenstantBox = boxSelection.getUserInput();

            result = BoxSelection.boxSelection(hostBox,contenstantBox,openBox,remainingBox,boxSelection);

            System.out.println("Do You Want To Continue(Y/N)");
            choice = boxSelection.getUserInputToContPrograme();
        } while(choice.equalsIgnoreCase("Y"));

        return result;
    }

}
