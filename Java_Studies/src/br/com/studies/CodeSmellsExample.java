package br.com.studies;

import java.util.*;

public class CodeSmellsExample {
    private int a;

    public void setA(int b) {
        a = b;
    }

    public int getA() {
        return a;
    }

    public boolean isNumberEven(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printEvenNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (isNumberEven(number)) {
                System.out.println(number);
            }
        }
    }

    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        if (number >= 0) {
            System.out.println("Positive number!");
        } else {
            System.out.println("Negative number!");
        }
    }

    public List<String> getEmptyList() {
        return Collections.EMPTY_LIST;
    }

    public Map<String, Integer> getEmptyMap() {
        return Collections.EMPTY_MAP;
    }

    public Set<String> getEmptySet() {
        return Collections.EMPTY_SET;
    }
}