package com.example.lv3.app.enums;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum OperatorType {
    ADD('+', Double::sum),
    SUBTRACT('-', (num1, num2) -> num1 - num2),
    MULTIPLY('*', (num1, num2) -> num1 * num2),
    DIVIDE('/', (num1, num2) -> num1 / num2);

    private final char symbol;
    private final BiFunction<Double, Double, Double> expression;

    OperatorType(char symbol, BiFunction<Double, Double, Double> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static Optional<OperatorType> findBySymbol(char symbol) {
        return Arrays.stream(values())
                .filter(o -> o.symbol == symbol)
                .findFirst();
    }

    public double evaluate(double num1, double num2) {
        return this.expression.apply(num1, num2);
    }
}
