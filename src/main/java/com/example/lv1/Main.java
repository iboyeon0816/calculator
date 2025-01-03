package com.example.lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isContinue = true;
        while(isContinue) {
            isContinue = calculate(sc);
        }
    }

    private static boolean calculate(Scanner sc) {
        System.out.println("사칙 연산을 시작합니다.");

        System.out.print("첫 번째 수를 입력하세요. (0 이상의 정수): ");
        int num1 = sc.nextInt();
        System.out.print("사칙 연산 기호를 입력하세요. (+, -, *, /): ");
        String operator = sc.next();
        System.out.print("두 번째 수를 입력하세요. (0 이상의 정수): ");
        int num2 = sc.nextInt();

        double result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("[ERROR] 0으로 나눌 수 없습니다.");
                    System.out.println();
                    return true;
                }
                result = num1 / (double) num2;
                break;
            default:
                System.out.println("[ERROR] 잘못된 연산자를 입력하였습니다.");
                System.out.println();
                return true;
        }
        System.out.println("[SUCCESS] " + num1 + " " + operator + " " + num2 + " = " + result);
        System.out.println();

        System.out.print("계속하시겠습니까? (끝내시려면 exit을 입력하세요.): ");
        String str = sc.next();
        System.out.println();

        return !"exit".equals(str);
    }
}