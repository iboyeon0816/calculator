package com.example.lv3.app.component;

import com.example.lv3.app.enums.OperatorType;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {

    private final List<Double> resultList = new ArrayList<>();

    public double calculate(int num1, int num2, OperatorType operator) {
        if (OperatorType.DIVIDE.equals(operator) && num2 == 0) {
            throw new IllegalArgumentException("[ERROR] 0으로 나눌 수 없습니다.");
        }

        double result = switch (operator) {
            case ADD -> num1 + num2;
            case SUBTRACT -> num1 - num2;
            case MULTIPLY -> num1 * num2;
            case DIVIDE -> num1 / (double) num2;
        };

        resultList.add(result);

        return result;
    }

    public Double removeFirst() {
        return resultList.remove(0);
    }

    public List<Double> getResultsGreaterThan(int num) {
        return resultList.stream()
                .filter(d -> d > num)
                .toList();
    }
}
