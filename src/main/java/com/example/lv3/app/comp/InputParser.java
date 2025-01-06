package com.example.lv3.app.comp;

import java.util.Scanner;

public class InputParser {

    private final Scanner scanner = new Scanner(System.in);

    public int getUserNumber() {
        System.out.print("수를 입력하세요. (0 이상의 정수): ");
        return scanner.nextInt();
    }

    public String getUserOperator() {
        System.out.print("사칙 연산 기호를 입력하세요. (+, -, *, /): ");
        String operator =  scanner.next();

        if (!operator.matches("[+\\-*/]")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 연산자를 입력하였습니다.");
        }

        return operator;
    }

    public String getExitOrContinue() {
        System.out.print("계속하시겠습니까? (끝내시려면 exit을 입력하세요.): ");
        String str = scanner.next();
        System.out.println();
        return str;
    }
}
