package com.example.lv3.enums;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum OperatorType {
    ADD('+', Double::sum, Long::sum),
    SUBTRACT('-', (num1, num2) -> num1 - num2, (num1, num2) -> num1 - num2),
    MULTIPLY('*', (num1, num2) -> num1 * num2, (num1, num2) -> num1 * num2),
    DIVIDE('/', (num1, num2) -> num1 / num2, (num1, num2) -> { throw new IllegalStateException(); });

    private final char symbol;
    private final BiFunction<Double, Double, Double> doubleExpression;
    private final BiFunction<Long, Long, Long> longExpression;

    OperatorType(char symbol,
                 BiFunction<Double, Double, Double> doubleExpression,
                 BiFunction<Long, Long, Long> longExpression) {
        this.symbol = symbol;
        this.doubleExpression = doubleExpression;
        this.longExpression = longExpression;
    }

    public static Optional<OperatorType> findBySymbol(char symbol) {
        return Arrays.stream(values())
                .filter(o -> o.symbol == symbol)
                .findFirst();
    }

    public Number evaluate(Number num1, Number num2) {
        if (num1 instanceof Long) {
            return longExpression.apply(num1.longValue(), num2.longValue());
        } else {
            return doubleExpression.apply(num1.doubleValue(), num2.doubleValue());
        }
    }
}
