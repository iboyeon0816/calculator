package com.example.lv3.app;

import com.example.lv3.app.component.ArithmeticCalculator;
import com.example.lv3.app.component.InputParser;
import com.example.lv3.app.enums.OperatorType;

import java.util.List;

public class CalculatorApp {

    private final InputParser inputParser = new InputParser();
    private final ArithmeticCalculator calculator = new ArithmeticCalculator();

    public void start() {
        boolean isExit = false;
        while(!isExit) {
            System.out.println("사칙 연산을 시작합니다.");

            Number num1 = inputParser.getUserNumber();
            OperatorType operatorType = inputParser.getUserOperator();
            Number num2 = inputParser.getUserNumber();

            if (num1 instanceof Long && num2 instanceof Long && !OperatorType.DIVIDE.equals(operatorType)) {
                long longNum1 = num1.longValue();
                long longNum2 = num2.longValue();
                long result = calculator.calculate(longNum1, longNum2, operatorType);
                System.out.println("[SUCCESS] result = " + result);
            }
            else {
                double doubleNum1 = num1.doubleValue();
                double doubleNum2 = num2.doubleValue();
                double result = calculator.calculate(doubleNum1, doubleNum2, operatorType);
                System.out.println("[SUCCESS] result = " + result);
            }

            System.out.println();

            isExit = inputParser.isExit();
        }

        System.out.println("입력 값보다 큰 결과 값들을 출력합니다.");
        Number num = inputParser.getUserNumber();
        List<Number> resultList = calculator.getResultsGreaterThan(num);
        resultList.forEach(d -> System.out.print(d + " "));
    }
}
