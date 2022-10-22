package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        System.out.println("Mein Speicher Test");

        long[] test = lcg(12345);
        for (int i = 0; i < 10; i++) {
            System.out.println(test[i]);
        }

        guessingGame(randomNumberBetweenOneAndHundred());


    }// end public static void main(String[] args)
    public static void oneMonthCalendar(int daysInMonth, int firstMonthDay) {
        // METHODENVARIABLEN
        int dayCounter = 0;


        // METHODENRUMPF
        // print first week
        for (int l = 1; l < firstMonthDay; l++) {
            System.out.printf("   ");
        }
        for (int m = 0; m <= (7 - firstMonthDay); m++) {
            dayCounter++;
            System.out.printf("%2d ", dayCounter);
        }
        System.out.println();

        // print rest of the weeks
        while (dayCounter < daysInMonth) {
            for (int j = 0; j < 7; j++) {
                dayCounter++;
                System.out.printf("%2d ", dayCounter);
                if (daysInMonth <= dayCounter) {
                    break;
                }
            }
            System.out.print(System.lineSeparator());
        }
    }// end  public static void oneMonthCalendar(int dayNumber, int firstDay)
    public static long[] lcg(long seed) {
        // METHODENVARIABLEN
        long[] randomNumbers = new long[10];


        // METHODENRUMPF
        randomNumbers[0] = nextRandomNumber(seed);

        for (int i = 1; i < 10; i++) {
            randomNumbers[i] = nextRandomNumber(randomNumbers[i - 1]);
        }

        return randomNumbers;
    }// end public static long[] lcg(long seed)
    public static long nextRandomNumber(long seed) {
        // METHODENVARIABLEN
        long a = 1103515245;
        long c = 12345;
        long m = 2147483648L;

        // METHODENRUMPF
        return ((a * seed) + c) % m;
    }// end public static long nextRandomNumber(long seed)
    public static void guessingGame(int numberToGuess) {
        // METHODENVARIABLEN
        int guess;
        Scanner consoleInput = new Scanner(System.in);


        // METHODENRUMPF
        // Versuche 1 - 9
        for (int i = 0; i < 9; i++) {
            System.out.printf("Guess number %d: ", (i + 1));
            guess = consoleInput.nextInt();
            if (guess < numberToGuess) {
                System.out.println("The number AI picked is higher than your guess.");
                continue;
            }
            else if (guess > numberToGuess){
                System.out.println("The number AI picked is lower than your guess.");
                continue;
            }
            else {
                System.out.println("You won wisenheimer!");
                return;
            }
        }

        // letzter Versuch
        System.out.printf("Guess number 10: ");
        guess = consoleInput.nextInt();
        if (guess == numberToGuess) {
            System.out.println("You won wisenheimer!");
        } else {
            System.out.println("You lost! Have you ever heard of divide & conquer?");
        }
    }// end public static void guessingGame(int numberToGuess)
    public static int randomNumberBetweenOneAndHundred() {
        // METHODENVARIABLEN
        Random random = new Random();


        // METHODENRUMPF
        return random.nextInt(100) + 1;
    }// end public static int randomNumberBetweenOneAndHundred()
    public static boolean swapArrays(int[] arrayA, int[] arrayB) {
        // METHODENVARIABLEN
        int tempVar;

        // METHODENRUMPF
        if(arrayA.length != arrayB.length) {
            return false;
        } else {
            for (int i = 0; i < arrayA.length; i++) {
                tempVar = arrayA[i];
                arrayA[i] = arrayB[i];
                arrayB[i] = tempVar;
            }
            return true;
        }
    }// end public static boolean swapArrays(int[] arrayA, int[] arrayB)
    public static void camelCase(String sentence) {

    }// end public static void camelCase(String sentence)
    public static int checkDigit(int[] code) {
        // METHODENVARIABLEN
        int summe = 0;
        int rest;
        int prüfZiffer;


        // METHODENRUMPF
        for (int i = 0; i < code.length; i++) {
            summe = summe + (code[i] * (i + 2));
        }

        rest = summe % 11;
        prüfZiffer = 11 - rest;

        switch (prüfZiffer) {
            case 10:
                prüfZiffer = 0;
                break;
            case 11:
                prüfZiffer = 5;
                break;
        }

        return prüfZiffer;
    }// public static int checkDigit(int[] code)
}