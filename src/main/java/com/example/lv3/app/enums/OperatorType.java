package com.example.lv3.app.enums;

import java.util.Arrays;
import java.util.Optional;

public enum OperatorType {
    ADD('+'), SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public static Optional<OperatorType> findBySymbol(char symbol) {
        return Arrays.stream(values())
                .filter(o -> o.symbol == symbol)
                .findFirst();
    }
}
