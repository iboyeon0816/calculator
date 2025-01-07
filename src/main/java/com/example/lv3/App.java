package com.example.lv3;

import com.example.lv3.enums.OperatorType;

import java.util.List;
import java.util.Scanner;

public class App {

    private static final Scanner sc = new Scanner(System.in);
    private static final ArithmeticCalculator<Long> longCalculator = new ArithmeticCalculator<>();
    private static final ArithmeticCalculator<Double> doubleCalculator = new ArithmeticCalculator<>();

    public static void main(String[] args) {
        boolean isExit = false;

        while(!isExit) {
            System.out.println("사칙 연산을 시작합니다.");

            Number num1 = getNumber();
            OperatorType operatorType = getOperator();
            Number num2 = getNumber();

            Number result;
            try {
                if (num1 instanceof Long && num2 instanceof Long && !operatorType.equals(OperatorType.DIVIDE)) {
                    result = longCalculator.calculate(num1.longValue(), num2.longValue(), operatorType);
                }
                else {
                    result = doubleCalculator.calculate(num1.doubleValue(), num2.doubleValue(), operatorType);
                }
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다. 연산을 처음부터 다시 시작합니다.\n");
                continue;
            }

            System.out.println("[SUCCESS] 계산 결과: " + result + "\n");

            isExit = getIsExit();
        }

        System.out.println("입력 값보다 큰 결과 값들을 출력합니다.");
        Number num = getNumber();
        printResults(longCalculator.getResultsGreaterThan(num));
        printResults(doubleCalculator.getResultsGreaterThan(num));
    }

    private static void printResults(List<Number> resultList) {
        resultList.forEach(n -> System.out.print(n + " "));
    }

    private static Number getNumber() {
        boolean isValid = false;
        Number inputNum = 0;

        while (!isValid) {
            try {
                System.out.print("수를 입력하세요: ");
                String input = sc.next();
                if (input.contains(".")) {
                    inputNum = Double.parseDouble(input);
                }
                else {
                    inputNum = Long.parseLong(input);
                }
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 형식의 입력입니다. 수를 입력해주세요.\n");
            }
        }

        return inputNum;
    }

    private static OperatorType getOperator() {
        boolean isValid = false;
        String input = "";

        while (!isValid) {
            System.out.print("사칙 연산 기호(+, -, *, /)를 입력하세요: ");
            input = sc.next();
            if (!input.matches("[+\\-*/]")) {
                System.out.println("잘못된 형식의 입력입니다. +, -, *, /만 입력할 수 있습니다.\n");
            }
            else {
                isValid = true;
            }
        }

        return OperatorType.findBySymbol(input.charAt(0))
                .orElseThrow(IllegalStateException::new);
    }

    private static boolean getIsExit() {
        System.out.print("계속하시겠습니까? (끝내시려면 exit을 입력하세요.): ");
        String input = sc.next();
        System.out.println();
        return "exit".equals(input);
    }

}