package com.example.lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 사칙 연산을 수행하고, 결과를 저장 및 관리하는 클래스
 *
 * 피연산자와 2개와 연산자 1개를 받아 사칙연산을 수행한다.
 * 연산 결과는 내부 큐에 저장한다.
 */
public class Calculator {

    private Queue<Double> resultQueue = new LinkedList<>(); // 연산 결과를 저장하는 큐

    /**
     * 피연산자 2개와 연산자 1개를 받아 사칙연산을 수행하는 메서드
     *
     * 연산 결과는 내부 큐에 저장한다.
     *
     * @param num1 첫 번째 피연산자 (0 이상의 정수)
     * @param num2 두 번째 피연산자 (0 이상의 정수)
     * @param operator 연산자 (+, -, *, / 중 하나)
     * @return 연산 결과
     * @throws ArithmeticException 0으로 나누는 경우
     */
    public double calculate(int num1, int num2, String operator) {
        if (operator.equals("/") && num2 == 0) {
            throw new ArithmeticException();
        }

        double result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / (double) num2;
            default -> throw new IllegalStateException();
        };

        resultQueue.add(result);

        return result;
    }

    /**
     * 큐에서 가장 먼저 저장된 연산 결과를 제거하는 메서드
     *
     * 큐에서 해당 값을 제거하고, 제거된 값을 반환한다.
     * @return 가장 먼저 저장된 연산 결과 (큐가 비어 있을 경우 null)
     */
    public Double poll() {
        return resultQueue.poll();
    }

    /**
     * 연산 결과가 저장된 큐를 반환하는 메서드
     *
     * @return 연산 결과를 저장한 큐
     */
    public Queue<Double> getResultQueue() {
        return resultQueue;
    }

    /**
     * 연산 결과를 저장할 큐를 설정하는 메서드
     *
     * @param resultQueue 새로운 연산 결과 큐
     */
    public void setResultQueue(Queue<Double> resultQueue) {
        this.resultQueue = resultQueue;
    }
}
