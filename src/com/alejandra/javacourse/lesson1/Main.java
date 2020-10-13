package com.alejandra.javacourse.lesson1;

import java.util.Arrays;

/**
 * Java doc comments
 **/
public class Main {

    public static double calculateAverage(double[] temperature) {
        int size = temperature.length;
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += temperature[i];
        }
        return total / size;
    }

    public String findLongestName(String [] names){
        int size = names.length;
        String max = names[0];

        for(int i=1; i < size; i++){
            if(names[i].length() > max.length()){
                max = names[i];
            }
        }
        return max;
    }

    public static double search( double [] speed){
        int size = speed.length;
        double min = speed[0];
        for(int i=1; i<size; i++){
            if(speed[i] < min){
                min = speed[i];
            }
        }
        return min;
    }

    public static int factorial(int n){
        int factorial = 1;
        for(int i=1; i<=n;i++){
            factorial= factorial*i;
        }
        return factorial;
    }

    public static int factorialRecursion(int n){
        if(n==0) return 1;
        else{
            return n*factorialRecursion(n-1);
        }
    }

    public static int indexOfFirstOccurrence(String[] stringArray, String target)
    {   int i=0;
        for(String word: stringArray){
            if(word.equals(target)){
                return i;
            }
            i++;
        }
        return -1;
    }


    public static int yearsTilOneMillion(double initialBalance) {
       double savings = initialBalance;
       int years=0;
        while(savings <= 1000000.0){
            savings=savings*1.05;
            years++;
        }
        return years;
    }


    public static void printInReverse(String[] stringArray) {
        for(int i=stringArray.length -1; i >= 0;i--){
            System.out.println(stringArray[i]);
        }
    }

    public static int findRange(int[] intArray) {
        if(intArray.length == 0)
        return -1;
        int min=intArray[0];
        int max=intArray[0];
        for(int i=1; i< intArray.length;i++){
            if(intArray[i]< min){
                min = intArray[i];
            }
            if(intArray[i]> max){
                max= intArray[i];
            }
        }
        return  max - min;
    }

    public static void main(String[] args) {
        int passangers;
        passangers = 0;
        passangers = passangers + 5;

        System.out.println("Hello World");
        System.out.println(2 + 3);

        String firstName = "Alejandra";
        String lastName = "Acevedo";
        String fullName = firstName + " " + lastName;
        System.out.println("Hello My name is " + fullName);
        System.out.println("There are " + (fullName.length() - 1) + " letters in my name");

        int fahrenheit = 68;
        double celsius = convertFahrenheitToCelsius(fahrenheit);
        System.out.println("F " + fahrenheit + " to C " + celsius);

        int[] ints = {-9, 1, 37, 102};
        System.out.println(A.exists(ints, 102));
        System.out.println(A.exists(ints, 36));
        System.out.println(A.exists2(ints, 102));
        System.out.println(A.exists2(ints, 36));
        int roll1 = rollDice(6);
        int roll2 = rollDice(10);
        System.out.println("Roll 1: " + roll1);
        System.out.println("Roll 2: " + roll2);
        System.out.println("Blocks for 3 floors " + countBlock(3));
        double[] array = {75, 73, 72, 80};
        System.out.println(" average temp is " + calculateAverage(array));

        //Recursion and factorial
        System.out.println("factorial of 5 "+ factorial(5));
        System.out.println("factorial of 5 recursive "+ factorialRecursion(5));

        //Check index in array
        String[] sentence = {"Learning", "Java", "is", "fun."};
        int indexOfWordJava = indexOfFirstOccurrence(sentence, "is");
        System.out.println(indexOfWordJava);

        //Print in reverse
        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        printInReverse(weekdays);

        // Return range
        int [] myIntArray= {1, 0, 2, 3, -1, 2};
        System.out.println(findRange(myIntArray));

    }


    public static double convertFahrenheitToCelsius(int farenheit) {
        return 5.0 * (farenheit - 32) / 9;
    }

    public static int rollDice(int sides) {
        return (int) (Math.random() * (sides) + 1);

    }

    public static int countBlock(int floors) {
        int blocks = 0;
        for (int i = 1; i <= floors; i++) {
            blocks = blocks + i * i;
        }

        return blocks;
    }


}

class A {
    // MOST OPTIMIZED SEARCH
    static boolean exists(int[] ints, int k) {
        if(ints.length == 0) return  false; //check if array is empty
        int result = Arrays.binarySearch(ints, k);
        return result > 0 ? true : false;
    }

    static boolean exists2(int[] ints, int k) {
        int i = 0;
        boolean hasValue = false;

        while (i < ints.length && !hasValue) {
            hasValue = ints[i] == k;
            i = i + 1;
        }
        return hasValue;
    }


    // optimized search java using sort of binary search
    static boolean exists3(int[] ints, int k) {
        int lower = 0;
        int upper = ints.length - 1;
        if (ints.length == 0) return false;
        if (k < ints[lower] || k > ints[upper]) return false;
        if (k == ints[lower]) return true;
        if (k == ints[upper]) return true;

        do {
            int middle = lower + (upper - lower) / 2;
            if (ints[middle] == k) return true;
            if (lower == upper) return false;
            if (k < ints[middle]) {
                upper = Math.max(lower, middle - 1);
            } else {
                lower = Math.min(upper, middle + 1);
            }
        } while (true);
    }
}

