package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {
    @Override
    public double addition(String firstNumber, String secondNumber) {

        checkParams(firstNumber, secondNumber);

        double a = Double.parseDouble(firstNumber.trim());
        double b = Double.parseDouble(secondNumber.trim());

        return a + b;
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {

        checkParams(firstNumber, secondNumber);

        double a = Double.parseDouble(firstNumber.trim());
        double b = Double.parseDouble(secondNumber.trim());

        return a - b;
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        checkParams(firstNumber, secondNumber);

        double a = Double.parseDouble(firstNumber.trim());
        double b = Double.parseDouble(secondNumber.trim());

        return a * b;
    }

    @Override
    public double division(String firstNumber, String secondNumber) {

        checkParams(firstNumber, secondNumber);

        double a = Double.parseDouble(firstNumber.trim());
        double b = Double.parseDouble(secondNumber.trim());

        return a / b;
    }

    public void checkParams(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) throw new  IllegalArgumentException();
        try {
            Double.parseDouble(firstNumber.trim());
        } catch (NumberFormatException e ) {
            System.out.println("First value is not a number.");
        }

        try {
            Double.parseDouble(secondNumber.trim());

        } catch (NumberFormatException e ) {
            System.out.println("Second value is not a number.");
        }
    }

}
