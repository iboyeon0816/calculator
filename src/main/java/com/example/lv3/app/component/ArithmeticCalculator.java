package com.example.lv3.app.component;

import com.example.lv3.app.enums.OperatorType;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {

    private final List<Number> resultList = new ArrayList<>();

    public <T extends Number> T calculate(T num1, T num2, OperatorType operator) {
        if (OperatorType.DIVIDE.equals(operator) && num2.doubleValue() == 0) {
            throw new IllegalArgumentException("[ERROR] 0으로 나눌 수 없습니다.");
        }

        if (num1 instanceof Long) {
            long result = operator.evaluate(num1.longValue(), num2.longValue());
            resultList.add(result);
            return (T) Long.valueOf(result);
        }
        else {
            double result = operator.evaluate(num1.doubleValue(), num2.doubleValue());
            resultList.add(result);
            return (T) Double.valueOf(result);
        }
    }

    public Number removeFirst() {
        return resultList.remove(0);
    }

    public List<Number> getResultsGreaterThan(Number num) {
        return resultList.stream()
                .filter(d -> d.doubleValue() > num.doubleValue())
                .toList();
    }
}
