package com.example.lv3.app.comp;

import java.util.LinkedList;
import java.util.Queue;

public class ArithmeticCalculator {

    private Queue<Double> resultQueue = new LinkedList<>();

    public double calculate(int num1, int num2, String operator) {
        if ("/".equals(operator) && num2 == 0) {
            throw new IllegalArgumentException("[ERROR] 0으로 나눌 수 없습니다.");
        }

        double result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / (double) num2;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
        resultQueue.add(result);
        return result;
    }

    public Double poll() {
        return resultQueue.poll();
    }

    public Queue<Double> getResultQueue() {
        return resultQueue;
    }

    public void setResultQueue(Queue<Double> resultQueue) {
        this.resultQueue = resultQueue;
    }
}
