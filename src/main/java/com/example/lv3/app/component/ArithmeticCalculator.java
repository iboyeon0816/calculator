package com.example.lv3.app.component;

import com.example.lv3.app.enums.OperatorType;

import java.util.LinkedList;
import java.util.Queue;

public class ArithmeticCalculator {

    private Queue<Double> resultQueue = new LinkedList<>();

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
