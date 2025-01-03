package com.example.lv2;

import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        boolean isContinue = true;
        while(isContinue) {
            isContinue = calculate(sc, calculator);
        }

        System.out.println("지금까지의 계산 결과를 출력합니다.");
        Queue<Double> resultQueue = calculator.getResultQueue();
        for (Double v : resultQueue) {
            System.out.print(v + " ");
        }
        System.out.println();

        System.out.println("첫 번째 계산 결과를 지우고 다시 출력합니다.");
        Double polled = calculator.poll();
        System.out.println("제거된 값: " + polled);
        if (calculator.getResultQueue().isEmpty()) {
            System.out.println("남은 값이 없습니다.");
        } else {
            System.out.print("남은 값: ");
            for (Double v : resultQueue) {
                System.out.print(v + " ");
            }
        }
    }

    private static boolean calculate(Scanner sc, Calculator calculator) {
        System.out.println("사칙 연산을 시작합니다.");

        System.out.print("첫 번째 수를 입력하세요. (0 이상의 정수): ");
        int num1 = sc.nextInt();
        System.out.print("사칙 연산 기호를 입력하세요. (+, -, *, /): ");
        String operator = sc.next();
        System.out.print("두 번째 수를 입력하세요. (0 이상의 정수): ");
        int num2 = sc.nextInt();

        if ("/".equals(operator) && num2 == 0) {
            System.out.println("[ERROR] 0으로 나눌 수 없습니다.");
            System.out.println();
            return true;
        }

        if (!operator.matches("[+\\-*/]")) {
            System.out.println("[ERROR] 잘못된 연산자를 입력하였습니다.");
            System.out.println();
            return true;
        }

        double result = calculator.calculate(num1, num2, operator);
        System.out.println("[SUCCESS] " + num1 + " " + operator + " " + num2 + " = " + result);
        System.out.println();

        System.out.print("계속하시겠습니까? (끝내시려면 exit을 입력하세요.): ");
        String str = sc.next();
        System.out.println();

        return !"exit".equals(str);
    }
}