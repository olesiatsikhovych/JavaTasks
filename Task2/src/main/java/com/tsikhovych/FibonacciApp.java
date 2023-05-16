package com.tsikhovych;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class FibonacciApp {


    public static void main(String[] args) {
        ArrayList fibonacci = new ArrayList();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть перше число: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Введіть друге число: ");
        int secondNumber = scanner.nextInt();
        System.out.println("Вкажіть бажану довжину інтервалу(кількість чисел): ");
        int numbers = scanner.nextInt();

        fibonacci.add(firstNumber);
        fibonacci.add(secondNumber);

        for (int i = 2; i < numbers; i++) {
            int nextNumber = firstNumber + secondNumber;
            fibonacci.add(nextNumber);
            firstNumber = secondNumber;
            secondNumber = nextNumber;
        }
        printEnteredInterval(fibonacci);
        printOddNumbers(fibonacci);
        printEvenNumbers(fibonacci);
        printSumOfOddNumbers(fibonacci);
        printSumOfEvenNumbers(fibonacci);
        printBiggestOddNumber(fibonacci);
        printBiggestEvenNumber(fibonacci);
        printPercentageOfOddNumbers(fibonacci);
        printPercentageOfEvenNumbers(fibonacci);
        printFibbonacciSet(fibonacci);
    }

    public static void printEnteredInterval(ArrayList<Integer> fibonacci) {
        System.out.println(fibonacci);
    }

    public static void printOddNumbers(ArrayList<Integer> fibonacci) {
        System.out.println("Виводимо непарні числа: ");
        for (int number : fibonacci) {
            if (number % 2 != 0)
                System.out.println(number);
        }
    }

    public static void printEvenNumbers(ArrayList<Integer> fibonacci) {
        System.out.println("Виводимо парні числа: ");
        for (int number : fibonacci) {
            if (number % 2 == 0)
                System.out.println(number);
        }
    }

    public static void printSumOfOddNumbers(ArrayList<Integer> fibonacci) {
        System.out.println("Виводимо суму непарних чисел: ");
        int sumOfOdd = 0;
        for (int number : fibonacci) {
            if (number % 2 != 0)
                sumOfOdd += number;
        }
        System.out.println(sumOfOdd);
    }

    public static void printSumOfEvenNumbers(ArrayList<Integer> fibonacci) {
        System.out.println("Виводимо суму парних чисел: ");
        int sumOfEven = 0;
        for (int number : fibonacci) {
            if (number % 2 == 0)
                sumOfEven += number;
        }
        System.out.println(sumOfEven);
    }

    public static void printFibbonacciSet(ArrayList<Integer> fibonacci) {
        System.out.println("Виводимо сет Фібоначчі: ");
        HashSet<Integer> fibonacc = new HashSet<Integer>();

        for (int i = 0; i < fibonacci.size(); i++)
            fibonacc.add(fibonacci.get(i));
        System.out.println(fibonacc);

    }

    public static void printBiggestOddNumber(ArrayList<Integer> fibonacci) {
        System.out.println("Виводимо найбільше непарне число: ");
        int biggestOdd = Integer.MIN_VALUE;
        for (int number : fibonacci) {
            if (number % 2 != 0 && number > biggestOdd) {
                biggestOdd = number;
            }
        }
        System.out.println(biggestOdd);

    }

    public static void printBiggestEvenNumber(ArrayList<Integer> fibonacci) {
        System.out.println("Виводимо найбільше парне число: ");
        int biggestEven = Integer.MIN_VALUE;
        for (int number : fibonacci) {
            if (number % 2 == 0 && number > biggestEven) {
                biggestEven = number;
            }
        }
        System.out.println(biggestEven);
    }

    public static void printPercentageOfOddNumbers(ArrayList<Integer> fibonacci) {
        System.out.println("Виводимо відсоток непарних чисел масиву списку: ");
        double countOfOdd = 0;
        for (int i = 0; i < fibonacci.size(); i++) {
            if (fibonacci.get(i) % 2 != 0)
                countOfOdd++;
        }
        double percentageOfOdd = (countOfOdd / fibonacci.size()) * 100;
        System.out.println(percentageOfOdd + "%");
    }

    public static void printPercentageOfEvenNumbers(ArrayList<Integer> fibonacci) {
        System.out.println("Виводимо відсоток парних чисел масиву списку: ");
        double countOfEven = 0;
        for (int i = 0; i < fibonacci.size(); i++) {
            if (fibonacci.get(i) % 2 == 0)
                countOfEven++;
        }
        double percentageOfEven = (countOfEven / fibonacci.size() * 100);
        System.out.println(percentageOfEven + "%");
    }
}
