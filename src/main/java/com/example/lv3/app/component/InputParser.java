package com.example.lv3.app.component;

import com.example.lv3.app.enums.OperatorType;

import java.util.Scanner;

public class InputParser {

    private final Scanner scanner = new Scanner(System.in);

    public int getUserNumber() {
        System.out.print("수를 입력하세요. (0 이상의 정수): ");
        return scanner.nextInt();
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

    public String getExitOrContinue() {
        System.out.print("계속하시겠습니까? (끝내시려면 exit을 입력하세요.): ");
        String str = scanner.next();
        System.out.println();
        return str;
    }
}
