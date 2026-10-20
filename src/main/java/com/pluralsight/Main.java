package com.pluralsight;

import java.util.*;

public class Main {

    static Scanner scanner=new Scanner(System.in);

    static String pickupDate=" ";
    static int rentalDays=-1;
    static int age=-1;

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
        System.out.print("Hello and welcome!");
        questionUser();
    }

    public static void questionUser(){
        String Answer="blank";
        if (pickupDate.equals(" ")) {
            System.out.print("enter date of vehicle pickup here ->: ");
            pickupDate = scanner.nextLine();
        }

        if (rentalDays==-1) {
            System.out.print("enter the number day's of renting the car for here ->: ");
            rentalDays = scanner.nextInt();
        }

        if (!hasAnswerToll) {
            System.out.print("enter (y)es if you want electronic toll tags? (y/n): ");
            Answer = scanner.nextLine().toLowerCase();

            if (Answer.equals("y") || Answer.equals("n")) {
                hasElectronicToll = Answer.equals("y");
                hasAnswerToll=true;
            } else {
                System.out.println("Please enter a valid answer");
                questionUser();
            }
            Answer = "blank";
        }

        if (!hasAnswerGPS) {
            System.out.print("enter (y)es if you want GPS enable? (y/n): ");
            Answer = scanner.nextLine().toLowerCase();

            if (Answer.equals("y") || Answer.equals("n")) {
                hasGPS = Answer.equals("y");
                hasAnswerGPS=true;
            } else {
                System.out.println("Please enter a valid answer");
                questionUser();
            }
            Answer = "blank";
        }

        if (!hasAnswerAssist) {
            System.out.print("enter (y)es if you want roadside assistance enable? (y/n): ");
            Answer = scanner.nextLine().toLowerCase();

            if (Answer.equals("y") || Answer.equals("n")) {
                hasRoadAssist = Answer.equals("y");
                hasAnswerAssist=true;
            } else {
                System.out.println("Please enter a valid answer");
                questionUser();
            }
        }

        if (age>0){
            System.out.print("enter your age here ->: ");
            age = scanner.nextInt();
        }

    }

}