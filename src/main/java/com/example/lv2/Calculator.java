package com.example.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    private Queue<Double> resultQueue = new LinkedList<>();

    public double calculate(int num1, int num2, String operator) {
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
