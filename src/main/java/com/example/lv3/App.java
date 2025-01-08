package com.example.lv3;

import com.example.lv3.enums.OperatorType;

import java.util.List;
import java.util.Scanner;

/**
 * 사용자로부터 피연산자 2개와 연산자 1개를 입력 받아 연산을 수행하고, 결과를 출력하는 클래스
 *
 * 사용자로부터 프로그램 종료 메시지("exit")를 받기 전까지 연산 수행을 반복한다.
 * 종료 메시지를 받으면 저장된 연산 결과를 필터링하여 출력하고 프로그램을 종료한다.
 *
 * 피연산자: 정수와 실수 모두 가능
 * 연산자: +, -, *, / 중 하나만 입력 가능
 */
public class App {

    private static final Scanner sc = new Scanner(System.in);
    private static final ArithmeticCalculator<Long> longCalculator = new ArithmeticCalculator<>();
    private static final ArithmeticCalculator<Double> doubleCalculator = new ArithmeticCalculator<>();

    public static void main(String[] args) {
        boolean isExit = false;

        // "exit"(종료 메시지)을 입력 받기 전까지 반복
        while(!isExit) {
            System.out.println("사칙 연산을 시작합니다.");

            // 피연산자와 연산자 입력 받기
            Number num1 = getNumber();
            OperatorType operatorType = getOperator();
            Number num2 = getNumber();

            // 타입 별 연산 수행
            Number result;
            try {
                // 연산 결과가 Long 타입이어도 되는 경우 피연산자를 Long 타입으로 변환하여 연산 수행
                if (num1 instanceof Long && num2 instanceof Long && !operatorType.equals(OperatorType.DIVIDE)) {
                    result = longCalculator.calculate(num1.longValue(), num2.longValue(), operatorType);
                }
                else { // 나머지는 피연산자를 Double 타입으로 변환하여 연산 수행
                    result = doubleCalculator.calculate(num1.doubleValue(), num2.doubleValue(), operatorType);
                }
            } catch (ArithmeticException e) {
                // 0 으로 나누기 예외 처리
                System.out.println("0으로 나눌 수 없습니다. 연산을 처음부터 다시 시작합니다.\n");
                continue;
            }

            // 연산 결과 출력
            System.out.println("[SUCCESS] 계산 결과: " + result + "\n");

            // 프로그램 종료 여부 확인
            isExit = getIsExit();
        }

        // 사용자 입력 값보다 큰 계산 결과 출력
        System.out.println("입력 값보다 큰 결과 값들을 출력합니다.");
        Number num = getNumber();
        printResults(longCalculator.getResultsGreaterThan(num));
        printResults(doubleCalculator.getResultsGreaterThan(num));
    }

    /**
     * 사용자로부터 수를 입력 받는 메서드
     *
     * 입력 받은 숫자가 실수인지 정수인지 판별하고 해당 타입으로 반환한다.
     * 유효하지 않은 입력이 들어오면 다시 입력을 요청한다.
     *
     * @return 입력 받은 숫자 (Long 또는 Double)
     */
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

    /**
     * 사용자로부터 연산자 기호를 입력 받는 메서드
     *
     * +, -, *, / 외 유효하지 않은 입력이 들어오면 다시 입력을 요청한다.
     *
     * @return 입력받은 연산자에 해당하는 OperatorType 객체
     */
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
     * 리스트에 저장된 연산 결과를 출력하는 메서드
     *
     * @param resultList 연산 결과를 저장하고 있는 리스트
     */
    private static void printResults(List<Number> resultList) {
        resultList.forEach(n -> System.out.print(n + " "));
    }
}