package com.example.lv3.app;

import com.example.lv3.app.component.ArithmeticCalculator;
import com.example.lv3.app.component.InputParser;
import com.example.lv3.app.enums.OperatorType;

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
    }
}
