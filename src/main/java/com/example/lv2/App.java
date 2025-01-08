package com.example.lv2;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 사용자로부터 피연산자 2개와 연산자 1개를 입력 받아 연산을 수행하고, 결과를 출력하는 클래스
 *
 * 사용자로부터 프로그램 종료 메시지("exit")를 받기 전까지 연산 수행을 반복한다.
 * 종료 메시지를 받으면 저장된 연산 결과를 출력하고 프로그램을 종료한다.
 *
 * 피연산자: 0 이상의 정수만 입력 가능
 * 연산자: +, -, *, / 중 하나만 입력 가능
 */
public class App {

    private static final Scanner sc = new Scanner(System.in);
    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        boolean isExit = false;

        // "exit"(종료 메시지)을 입력 받기 전까지 반복
        while(!isExit) {
            System.out.println("사칙 연산을 시작합니다.");

            // 피연산자와 연산자 입력 받기
            int num1 = getNumber();
            String operator = getOperator();
            int num2 = getNumber();

            try {
                // 연산 수행 및 결과 출력
                double result = calculator.calculate(num1, num2, operator);
                System.out.println("[SUCCESS] 계산 결과: " + result + "\n");
            } catch (ArithmeticException e) {
                // 0 으로 나누기 예외 처리
                System.out.println("0으로 나눌 수 없습니다. 연산을 처음부터 다시 시작합니다.\n");
                continue;
            }

            // 프로그램 종료 여부 확인
            isExit = getIsExit();
        }

        Queue<Double> resultQueue = calculator.getResultQueue();
        if (!resultQueue.isEmpty()) {
            // 저장된 계산 결과 출력
            System.out.println("지금까지의 계산 결과를 출력합니다.");
            printResults(resultQueue);

            // 첫 번째 계산 결과를 큐에서 제거하고, 그 값을 출력
            System.out.println("\n첫 번째 계산 결과를 지웁니다.");
            Double removedResult = calculator.poll();
            System.out.println("제거된 값: " + removedResult + "\n");

            // 남은 계산 결과 출력
            if (!resultQueue.isEmpty()) {
                System.out.println("남은 계산 결과를 다시 출력합니다.");
                printResults(resultQueue);
            }

            // 결과 큐 새로 초기화
            calculator.setResultQueue(new LinkedList<>());
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

    /**
     * 사용자로부터 사칙 연산 기호를 입력 받는 메서드
     *
     * 유효하지 않은 입력이 들어오면 다시 입력을 요청한다.
     *
     * @return 사칙 연산 기호 (+, -, *, /)
     */
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

    /**
     * 큐에 저장된 연산 결과를 출력하는 메서드
     *
     * @param resultQueue 연산 결과를 저장하고 있는 큐
     */
    private static void printResults(Queue<Double> resultQueue) {
        for (double result : resultQueue) {
            System.out.print(result + " ");
        }
        System.out.println();
    }
}