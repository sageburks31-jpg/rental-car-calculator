package com.pluralsight;

import java.util.*;

public class Main {

    static Scanner scanner=new Scanner(System.in);

    static String pickupDate=" ";
    static int rentalDays=-1;
    static int age=-1;
    static double surcharge=.3;

    static double electronicTollAmount=3.95;
    static boolean hasElectronicToll=false;
    static boolean hasAnswerToll=false;

    static double GPSAmount=2.95;
    static boolean hasGPS=false;
    static boolean hasAnswerGPS=false;

    static double roadAssistAmount=3.95;
    static boolean hasRoadAssist=false;
    static boolean hasAnswerAssist=false;

    public static void main(String[] args) {
        questionUser();
        printRentalDisplay();
    }

    public static void printRentalDisplay(){

        if (!hasElectronicToll) {electronicTollAmount=0;}

        if (!hasAnswerGPS) {GPSAmount=0;}

        if (!hasRoadAssist) {roadAssistAmount=0;}

        if (age<25) {surcharge=0;}

        System.out.printf("""
                        
                        *==== total car rental cost ====*
                        
                        basic car rental: 29.99 per days(%d)
                        electronic toll: %f
                        GPS: %f
                        roadside assistance: %f
                        underage supercharge percent: %f
                        """,rentalDays,electronicTollAmount,GPSAmount,roadAssistAmount,surcharge*10);

        if(surcharge==0){surcharge=1;}

        System.out.println("total cost: "+((29.99*rentalDays)+electronicTollAmount+GPSAmount+roadAssistAmount)*surcharge);

    }

    public static void questionUser(){
        if (pickupDate.equals(" ")) {
            System.out.print("enter date of vehicle pickup here ->: ");
            pickupDate = scanner.nextLine();
        }

        if (rentalDays==-1) {
            System.out.print("enter the number day's of renting the car for here ->: ");
            rentalDays = scanner.nextInt();
        }

        if (age>0){
            System.out.print("enter your age here ->: ");
            age = scanner.nextInt();
        }

        if (!hasAnswerToll) {
            System.out.print("enter (y)es if you want electronic toll tags? (y/n): ");
            ansStringCheck(scanner.nextLine().toLowerCase(),1);
        }

        if (!hasAnswerGPS) {
            System.out.print("enter (y)es if you want GPS enable? (y/n): ");
            ansStringCheck(scanner.nextLine().toLowerCase(),2);
        }

        if (!hasAnswerAssist) {
            System.out.print("enter (y)es if you want roadside assistance enable? (y/n): ");
            ansStringCheck(scanner.nextLine().toLowerCase(),3);
        }

    }


    public static void ansStringCheck(String Answer, int checkResKey) {

        if (Answer.equals("y") || Answer.equals("n")) {
            if (checkResKey == 3) {
                hasRoadAssist = Answer.equals("y");
                hasAnswerAssist = true;

            } else if (checkResKey == 2) {
                hasGPS = Answer.equals("y");
                hasAnswerGPS = true;

            } else if (checkResKey == 1) {
                hasElectronicToll = Answer.equals("y");
                hasAnswerToll = true;
            }
        } else {mistakeAnswerCheck();}
    }

    public static void mistakeAnswerCheck(){
        System.out.println("Please enter a valid answer");
        questionUser();
    }

}