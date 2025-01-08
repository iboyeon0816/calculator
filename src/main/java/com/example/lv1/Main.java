package com.example.lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 사용자로부터 피연산자 2개와 연산자 1개를 입력 받아 연산을 수행하고, 결과를 출력하는 클래스
 *
 * 사용자로부터 프로그램 종료 메시지("exit")를 받기 전까지 연산 수행을 반복한다.
 *
 * 피연산자: 0 이상의 정수만 입력 가능
 * 연산자: +, -, *, / 중 하나만 입력 가능
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isExit = false;

        // "exit"(종료 메시지)을 입력 받기 전까지 반복
        while(!isExit) {
            System.out.println("사칙 연산을 시작합니다.");

            // 피연산자와 연산자 입력 받기
            int num1 = getNumber();
            String operator = getOperator();
            int num2 = getNumber();

            // 0으로 나누는 경우 처리
            if (operator.equals("/") && num2 == 0) {
                System.out.println("0으로 나눌 수 없습니다. 연산을 처음부터 다시 시작합니다.\n");
                continue;
            }

            // 연산 수행
            double result = switch (operator) {
                case "+" -> num1 + num2;
                case "-" -> num1 - num2;
                case "*" -> num1 * num2;
                case "/" -> num1 / (double) num2;
                default -> throw new IllegalStateException();
            };

            // 결과 출력
            System.out.println("[SUCCESS] 계산 결과: " + result + "\n");

            // 프로그램 종료 여부 확인
            isExit = getIsExit();
        }
    }

    /**
     * 사용자로부터 0 이상의 정수를 입력 받는 메서드
     *
     * 유효하지 않은 입력이 들어오면 다시 입력을 요청한다.
     *
     * @return 0 이상의 정수 값
     */
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

    /**
     * 사용자로부터 사칙 연산 기호를 입력 받는 메서드
     *
     * 유효하지 않은 입력이 들어오면 다시 입력을 요청한다.
     *
     * @return 사칙 연산 기호 (+, -, *, /)
     */
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

    /**
     * 사용자로부터 프로그램 종료 여부를 입력 받는 메서드
     *
     * @return true - 사용자가 "exit"을 입력한 경우, false - 다른 입력이 들어온 경우
     */
    private static boolean getIsExit() {
        System.out.print("계속하시겠습니까? (끝내시려면 exit을 입력하세요.): ");
        String input = sc.next();
        System.out.println();
        return "exit".equals(input);
    }
}