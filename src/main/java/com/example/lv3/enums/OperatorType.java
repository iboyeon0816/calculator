package com.example.lv3.enums;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * 연산자 종류와 해당 연산 로직을 정의한 Enum 클래스
 *
 * 각 연산자에 대해 두 가지 타입(Double, Long)의 연산 로직을 정의하고,
 * 주어진 두 피연산자의 타입에 맞는 연산을 수행한다.
 */
public enum OperatorType {
    // 각 연산자에 대한 심볼과 두 가지 타입(Double, Long)의 연산 로직을 정의한다.
    ADD('+', Double::sum, Long::sum),
    SUBTRACT('-', (num1, num2) -> num1 - num2, (num1, num2) -> num1 - num2),
    MULTIPLY('*', (num1, num2) -> num1 * num2, (num1, num2) -> num1 * num2),
    DIVIDE('/', (num1, num2) -> num1 / num2, (num1, num2) -> { throw new IllegalStateException(); });

    private final char symbol; // 연산자의 심볼
    private final BiFunction<Double, Double, Double> doubleExpression; // Double 타입에 대한 연산 로직
    private final BiFunction<Long, Long, Long> longExpression; // Long 타입에 대한 연산 로직

    OperatorType(char symbol,
                 BiFunction<Double, Double, Double> doubleExpression,
                 BiFunction<Long, Long, Long> longExpression) {
        this.symbol = symbol;
        this.doubleExpression = doubleExpression;
        this.longExpression = longExpression;
    }

    /**
     * 주어진 연산자의 심볼에 해당하는 연산자 타입을 반환하는 메서드
     *
     * @param symbol 연산자 심볼
     * @return 해당하는 연산자 타입의 Optional (없으면 빈 Optional)
     */
    public static Optional<OperatorType> findBySymbol(char symbol) {
        return Arrays.stream(values())
                .filter(o -> o.symbol == symbol)
                .findFirst();
    }

    /**
     * 주어진 두 피연산자에 대해 연산을 수행하는 메서드
     *
     * 피연산자의 타입에 맞는 연산 로직을 사용한다.
     *
     * @param num1 첫 번째 피연산자
     * @param num2 두 번째 피연산자
     * @return 연산 결과
     */
    public Number evaluate(Number num1, Number num2) {
        if (num1 instanceof Long) {
            return longExpression.apply(num1.longValue(), num2.longValue());
        } else {
            return doubleExpression.apply(num1.doubleValue(), num2.doubleValue());
        }
    }
}
