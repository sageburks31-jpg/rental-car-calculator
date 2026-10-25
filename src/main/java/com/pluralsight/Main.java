package com.pluralsight;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static String pickupDate = " ";

    static int rentalDays = -1;
    static int age = -1;
    static double surcharge = .3;


    static double electronicTollAmount = 3.95;
    static boolean hasElectronicToll = false;
    static boolean hasAnswerToll = false;

    static double GPSAmount = 2.95;
    static boolean hasGPS = false;
    static boolean hasAnswerGPS = false;

    static double roadAssistAmount = 3.95;
    static boolean hasRoadAssist = false;
    static boolean hasAnswerAssist = false;

    public static void main(String[] args) {
        questionUser();
        printRentalDisplay();
    }

    public static void printRentalDisplay(){
        if (!hasElectronicToll) {electronicTollAmount = 0;}
        if (!hasAnswerGPS) {GPSAmount = 0;}

        if (!hasRoadAssist) {roadAssistAmount=0;}
        if (age >= 25) {surcharge = 0;}
        String strSurcharge=String.format("%.0f", surcharge * 100) + "%";

        System.out.printf("""
                        
                        *==== total car rental cost ====*
                        
                        rental date: %s
                        basic car rental: 29.99 per days(%d)
                        electronic toll: %.2f
                        GPS: %.2f
                        roadside assistance: %.2f
                        supercharge percentage: %s
                        """,
                pickupDate,
                rentalDays,
                electronicTollAmount,
                GPSAmount,
                roadAssistAmount,
                strSurcharge);
        if (surcharge == 0) {surcharge = 1;}

        double subTotal = 29.99 * surcharge;

        double superTotal = 29.99 + subTotal;
        double finalTotal = ((superTotal + electronicTollAmount + GPSAmount + roadAssistAmount) * rentalDays);
        System.out.printf("total cost: %.2f", finalTotal);
    }

    public static void questionUser(){

        if (pickupDate.equals(" ")) {
            System.out.print("enter date of vehicle pickup here ->: ");
            pickupDate = scanner.nextLine();
        }

        if (rentalDays == -1) {
            System.out.print("enter the number day's of renting the car for here ->: ");
            rentalDays = scanner.nextInt();
        }

        if (17 > age || 17 == age){
            System.out.print("enter your age here ->: ");
            age = scanner.nextInt();

            scanner.nextLine();
            if (age < 18) {mistakeAnswerCheck(false);}
        }

        if (!hasAnswerToll) {
            System.out.print("enter (y)es if you want electronic toll tags? (y/n): ");
            ansStringCheck(scanner.nextLine().toLowerCase(), 1);
        }

        if (!hasAnswerGPS) {
            System.out.print("enter (y)es if you want GPS enable? (y/n): ");
            ansStringCheck(scanner.nextLine().toLowerCase(), 2);
        }

        if (!hasAnswerAssist) {
            System.out.print("enter (y)es if you want roadside assistance enable? (y/n): ");
            ansStringCheck(scanner.nextLine().toLowerCase(), 3);
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
        }
        else {mistakeAnswerCheck(true);}
    }

    public static void mistakeAnswerCheck(boolean isString){
        if (isString) {
            System.out.println("Please enter a valid answer");
        } else {
            System.out.println("Please enter a valid age");
        }
        questionUser();
    }

}