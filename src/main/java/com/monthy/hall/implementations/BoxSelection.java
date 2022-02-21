package com.monthy.hall.implementations;

import com.monthy.hall.constants.Constants;
import com.monthy.hall.interfaces.IBoxSelection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoxSelection implements IBoxSelection {
    private final Scanner scanner = new Scanner(System.in);
    static List<Integer> boxList = new ArrayList<>();
    int count = 0;
    static{
        boxList.add(1);
        boxList.add(2);
        boxList.add(3);
    }

    public int getUserInput() {
        int input = scanner.nextInt();
        if(!boxList.contains(input)){
            System.out.println("Invalid Input, Please select Box between 1-3 !");
            count++;
                if(count >= 3){
                    System.out.println("Contenstant retried max attempt, Please try later ");
                }else {
                    return getUserInput();
                }
        }
        return input;
    }

    @Override
    public String getUserInputToContPrograme() {
        return scanner.next();
    }

    public static String boxSelection(int hostBox, int contenstantBox, int openBox, int remainingBox, BoxSelection userInput) {
        //moneyBox= 1, select 2, tv- 1,3, open 3, option 1,2
        if(hostBox == Constants.FIRST_BOX && contenstantBox == Constants.FIRST_BOX ){
            openBox=Constants.SECOND_BOX; remainingBox=Constants.THIRD_BOX;
            return executeBasedOnBoxSelection(openBox,remainingBox,hostBox,contenstantBox,userInput);
        }
        //moneyBox= 1, select 2, tv- 1,3, open 3, option 1,2
        else if(hostBox == Constants.FIRST_BOX && contenstantBox == Constants.SECOND_BOX ){
            openBox=Constants.THIRD_BOX; remainingBox=Constants.FIRST_BOX;
            return executeBasedOnBoxSelection(openBox,remainingBox,hostBox,contenstantBox, userInput);
        }
        //moneyBox= 1, select 3, tv- 1,2, open 2, option 1,3
        else if(hostBox == Constants.FIRST_BOX && contenstantBox == Constants.THIRD_BOX ){
            openBox=Constants.FIRST_BOX; remainingBox=Constants.FIRST_BOX;
            return executeBasedOnBoxSelection(openBox,remainingBox,hostBox,contenstantBox, userInput);
        }
        //moneyBox= 2, select 1, tv- 2,3, open 2, option 1, 2
        else if(hostBox == Constants.SECOND_BOX && contenstantBox == Constants.FIRST_BOX ){
            openBox=Constants.THIRD_BOX; remainingBox=Constants.SECOND_BOX;
            return executeBasedOnBoxSelection(openBox,remainingBox,hostBox,contenstantBox, userInput);
        }
        //moneyBox= 2, select 1, tv- 2,3, open 2, option 1, 2
        else if(hostBox == Constants.SECOND_BOX && contenstantBox == Constants.SECOND_BOX ){
            openBox=Constants.THIRD_BOX; remainingBox=Constants.FIRST_BOX;
            return executeBasedOnBoxSelection(openBox,remainingBox,hostBox,contenstantBox, userInput);
        }
        //moneyBox= 2, select 1, tv- 2,3, open 2, option 2, 3
        else if(hostBox == Constants.SECOND_BOX && contenstantBox == Constants.THIRD_BOX ){
            openBox=Constants.FIRST_BOX; remainingBox=Constants.SECOND_BOX;
            return executeBasedOnBoxSelection(openBox,remainingBox,hostBox,contenstantBox, userInput);
        }
        //moneyBox= 3, select 1, tv- 2,3, open 2, option 1, 3
        else if(hostBox == Constants.THIRD_BOX && contenstantBox == Constants.FIRST_BOX ){
            openBox=Constants.SECOND_BOX; remainingBox=Constants.THIRD_BOX;
            return executeBasedOnBoxSelection(openBox,remainingBox,hostBox,contenstantBox, userInput);
        }
        //moneyBox= 3, select 2, tv- 1,3, open 1, option 1, 3
        else if(hostBox == Constants.THIRD_BOX && contenstantBox == Constants.SECOND_BOX ){
            openBox=Constants.FIRST_BOX; remainingBox=Constants.THIRD_BOX;
            return executeBasedOnBoxSelection(openBox,remainingBox,hostBox,contenstantBox, userInput);
        }
        //moneyBox= 3, select 2, tv- 2,3, open 2, option 1, 3
        else if(hostBox == Constants.THIRD_BOX && contenstantBox == Constants.THIRD_BOX ){
            openBox=Constants.SECOND_BOX; remainingBox=Constants.FIRST_BOX;
            return executeBasedOnBoxSelection(openBox,remainingBox,hostBox,contenstantBox, userInput);
        }
        return null;
    }

    public static String executeBasedOnBoxSelection(int openBox, int remainingBox, int hostBox, int contenstantBox, BoxSelection userInput) {
        System.out.println("Host turn now to open any one box, Host open box: "+ openBox);
        System.out.println("Do you want to switch from "+ contenstantBox +" to "+ remainingBox +" (Y/N)");
        String changeBox = userInput.getUserInputToContPrograme();

        if(changeBox.equalsIgnoreCase("Y")){
            contenstantBox = remainingBox;
            return resultWinLose(hostBox,contenstantBox);
        } else if(changeBox.equalsIgnoreCase("N")){
            contenstantBox = remainingBox;
            return resultWinLose(hostBox,contenstantBox);
        } else {
            System.out.println("Invalid Input !!");
            return "Invalid Input";
        }
    }

    public static String resultWinLose(int hostBox, int contenstantBox) {
        if(hostBox == contenstantBox){
            System.out.println("You Win !!");
            return "You Win";
        } else {
            System.out.println("You Lose");
            System.out.println("Money in box "+hostBox);
            return "You Lose";
        }
    }
}
