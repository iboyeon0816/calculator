package com.example.lv3;

import com.example.lv3.enums.OperatorType;

import java.util.ArrayList;
import java.util.List;

/**
 * 다양한 타입의 수에 대해 사칙 연산을 수행하고, 결과를 저장 및 관리하는 클래스
 *
 * 피연산자와 2개와 연산자 1개를 받아 사칙연산을 수행한다.
 * 연산 결과는 내부 리스트에 저장한다.
 */
public class ArithmeticCalculator <T extends Number> {

    private final List<Number> resultList = new ArrayList<>(); // 연산 결과를 저장하는 리스트

    /**
     * 피연산자 2개와 연산자 1개를 받아 사칙연산을 수행하는 메서드
     *
     * 연산 결과는 내부 리스트에 저장한다.
     *
     * @param num1 첫 번째 피연산자
     * @param num2 두 번째 피연산자
     * @param operator 연산자
     * @return 연산 결과
     * @throws ArithmeticException 0으로 나누는 경우
     */
    public Number calculate(T num1, T num2, OperatorType operator) {
        if (OperatorType.DIVIDE.equals(operator) && num2.doubleValue() == 0) {
            throw new ArithmeticException();
        }

        Number result = operator.evaluate(num1, num2);
        resultList.add(result);
        return result;
    }

    /**
     * 저장된 연산 결과 중 주어진 숫자보다 큰 값을 필터링하여 반환하는 메서드
     *
     * @param num 비교할 숫자
     * @return 주어진 수보다 큰 계산 결과의 리스트
     */
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
