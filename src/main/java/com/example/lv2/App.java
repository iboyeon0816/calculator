package com.example.lv2;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {

    private static final Scanner sc = new Scanner(System.in);
    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        boolean isExit = false;

        while(!isExit) {
            System.out.println("사칙 연산을 시작합니다.");

            int num1 = getNumber();
            String operator = getOperator();
            int num2 = getNumber();

            double result;
            try {
                result = calculator.calculate(num1, num2, operator);
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다. 연산을 처음부터 다시 시작합니다.\n");
                continue;
            }
            System.out.println("[SUCCESS] 계산 결과: " + result + "\n");

            isExit = getIsExit();
        }

        Queue<Double> resultQueue = calculator.getResultQueue();
        if (!resultQueue.isEmpty()) {
            System.out.println("지금까지의 계산 결과를 출력합니다.");
            printResults(resultQueue);

            System.out.println("첫 번째 계산 결과를 지웁니다.");
            Double removedResult = calculator.poll();
            System.out.println("제거된 값: " + removedResult + "\n");

            if (!resultQueue.isEmpty()) {
                System.out.println("남은 계산 결과를 다시 출력합니다.");
                printResults(resultQueue);
            }

            calculator.setResultQueue(new LinkedList<>());
        }
    }

    private static int getNumber() {
        boolean isValid = false;
        int input = 0;

        while (!isValid) {
            try {
                System.out.print("피연산자를 입력하세요. (0 이상의 정수): ");
                input = sc.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 형식의 입력입니다. 0 이상의 정수만 입력해주세요.\n");
                sc.next();
            }
        }

        return input;
    }

    private static String getOperator() {
        boolean isValid = false;
        String input = "";

        while (!isValid) {
            System.out.print("사칙 연산 기호를 입력하세요. (+, -, *, /): ");
            input = sc.next();
            if (!input.matches("[+\\-*/]")) {
                System.out.println("잘못된 형식의 입력입니다. +, -, *, /만 입력할 수 있습니다.\n");
            }
            else {
                isValid = true;
            }
        }

        return input;
    }

    private static boolean getIsExit() {
        System.out.print("계속하시겠습니까? (끝내시려면 exit을 입력하세요.): ");
        String input = sc.next();
        System.out.println();
        return "exit".equals(input);
    }

    private static void printResults(Queue<Double> resultQueue) {
        for (double result : resultQueue) {
            System.out.print(result + " ");
        }
        System.out.println();
    }
}