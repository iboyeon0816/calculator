package com.example.lv3.app;

import com.example.lv3.app.component.ArithmeticCalculator;
import com.example.lv3.app.component.InputParser;
import com.example.lv3.app.enums.OperatorType;

import java.util.List;

public class CalculatorApp {

    private final InputParser inputParser = new InputParser();
    private final ArithmeticCalculator calculator = new ArithmeticCalculator();

    public void start() {
        boolean isContinue = true;
        while(isContinue) {
            System.out.println("사칙 연산을 시작합니다.");

            int num1 = inputParser.getUserNumber();
            OperatorType operatorType = inputParser.getUserOperator();
            int num2 = inputParser.getUserNumber();

            double result = calculator.calculate(num1, num2, operatorType);
            System.out.println("[SUCCESS] result = " + result);
            System.out.println();

            String str = inputParser.getExitOrContinue();
            isContinue = !"exit".equals(str);
        }

        System.out.println("입력 값보다 큰 결과 값들을 출력합니다.");
        int num = inputParser.getUserNumber();
        List<Double> resultList = calculator.getResultsGreaterThan(num);
        resultList.forEach(d -> System.out.print(d + " "));
    }
}
