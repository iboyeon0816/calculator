package com.example.lv3.app.component;

import com.example.lv3.app.enums.OperatorType;

import java.util.Scanner;

public class InputParser {

    private final Scanner scanner = new Scanner(System.in);

    public Number getUserNumber() {
        System.out.print("수를 입력하세요. : ");
        String input = scanner.next();

        if (input.contains(".")) {
            return Double.parseDouble(input);
        }
        else {
            return Long.parseLong(input);
        }
    }

    public OperatorType getUserOperator() {
        System.out.print("사칙 연산 기호를 입력하세요. (+, -, *, /): ");
        String input = scanner.next();

        if (input.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 잘못된 연산자를 입력하였습니다.");
        }

        char symbol = input.charAt(0);
        return OperatorType.findBySymbol(symbol)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 연산자를 입력하였습니다."));
    }

    public boolean isExit() {
        System.out.print("계속하시겠습니까? (끝내시려면 exit을 입력하세요.): ");
        String input = scanner.next();
        System.out.println();
        return "exit".equals(input);
    }
}
