package com.example.lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isExit = false;

        while(!isExit) {
            System.out.println("사칙 연산을 시작합니다.");

            int num1 = getNumber();
            String operator = getOperator();
            int num2 = getNumber();

            if (operator.equals("/") && num2 == 0) {
                System.out.println("0으로 나눌 수 없습니다. 연산을 처음부터 다시 시작합니다.\n");
                continue;
            }

            double result = switch (operator) {
                case "+" -> num1 + num2;
                case "-" -> num1 - num2;
                case "*" -> num1 * num2;
                case "/" -> num1 / (double) num2;
                default -> 0;
            };

            System.out.println("[SUCCESS] 계산 결과: " + result + "\n");

            isExit = getIsExit();
        }
    }

    private static int getNumber() {
        boolean isValidNumber = false;
        int input = 0;

        while (!isValidNumber) {
            try {
                System.out.print("피연산자를 입력하세요. (0 이상의 정수): ");
                input = sc.nextInt();
                isValidNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 형식의 입력입니다. 0 이상의 정수만 입력해주세요.\n");
                sc.next();
            }
        }

        return input;
    }

    private static String getOperator() {
        boolean isValidOperator = false;
        String input = "";

        while (!isValidOperator) {
            System.out.print("사칙 연산 기호를 입력하세요. (+, -, *, /): ");
            input = sc.next();
            if (!input.matches("[+\\-*/]")) {
                System.out.println("잘못된 형식의 입력입니다. +, -, *, /만 입력할 수 있습니다.\n");
            }
            else {
                isValidOperator = true;
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
}