package controller;

import controller.interfeces.StartProject;

import java.util.Scanner;

// This class is designed to interact with the user.

public class StartProjectImpl implements StartProject {

//    private CalculationSumFactorialNumber SumFactorialNumber = new CalculationSumFactorialNumberImpl();

    public StartProjectImpl() {
    }

//    public StartProjectImpl(CalculationSumFactorialNumber catalanNumber) {
//        this.SumFactorialNumber = catalanNumber;
//    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value N: ");
        int a = scanner.nextInt();

//        System.out.println("Sum of digits of the factorial of N = " + a + " equals: " + SumFactorialNumber.sumFactorialNumber(a));
    }
}
