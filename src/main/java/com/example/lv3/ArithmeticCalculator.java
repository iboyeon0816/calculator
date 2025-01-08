package com.example.lv3;

import com.example.lv3.enums.OperatorType;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator <T extends Number> {

    private final List<Number> resultList = new ArrayList<>();

    public Number calculate(T num1, T num2, OperatorType operator) {
        if (OperatorType.DIVIDE.equals(operator) && num2.doubleValue() == 0) {
            throw new ArithmeticException();
        }

        Number result = operator.evaluate(num1, num2);
        resultList.add(result);
        return result;
    }

    public List<Number> getResultsGreaterThan(Number num) {
        return resultList.stream()
                .filter(r -> {
                    if (r instanceof Long && num instanceof Long) {
                        return r.longValue() > num.longValue();
                    }
                    else {
                        return r.doubleValue() > num.doubleValue();
                    }
                })
                .toList();
    }
}
