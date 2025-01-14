# 간단한 사칙연산 계산기 만들기
사용자로부터 입력받은 값을 기반으로 사칙연산을 수행하는 계산기 애플리케이션을 개발하는 과제입니다.

Java 문법과 객체지향 설계를 학습하기 위한 과제로, 단계적으로 기능을 확장하며 개발되었습니다.

<br>

## 개발 환경
- **Language**: Java 17
- **IDE**: IntelliJ IDEA

<br>

## 프로젝트 구조
```
src/main/java/com/example
├── lv1
│   └── Main.java
├── lv2
│   ├── App.java
│   └── Calculator.java
├── lv3
│   ├── enums
│   │   └── OperatorType.java
│   ├── App.java
│   └── ArithmeticCalculator.java
``` 

<br>

## 요구사항
### [LEVEL 1] Java의 기본 문법을 활용한 계산기 만들기
1. **입력 처리**
   - 사용자는 피연산자 2개와 연산자 1개를 입력해야 합니다.
   - 피연산자는 0 또는 양의 정수로 제한됩니다.
   - 연산자는 `+`, `-`, `*`, `/` 중 하나여야 합니다.

2. **연산 수행**
   - 입력받은 값을 기반으로 연산을 수행하고, 결과를 출력합니다.
   - 연산 중 오류가 발생한 경우(예: 0으로 나누기) 에러 메시지를 출력합니다.

3. **프로그램 실행 흐름**
   - 사용자에게 프로그램을 계속 실행할 것인지 여부를 묻습니다.
   - 사용자가 `"exit"`을 입력하면 프로그램을 종료합니다.
   - 사용자가 `"exit"`을 입력하지 않으면 1단계로 돌아갑니다.

<br>

### [LEVEL 2] 클래스를 적용한 계산기 만들기
1. **연산 수행 기능 위임**
   - 레벨 1의 연산 수행 기능을 `Calculator` 클래스에 위임합니다.

2. **연산 결과 저장**
   - `Calculator` 클래스는 연산 결과를 `Collection` 필드에 저장합니다. 

3. **Calculator 클래스 활용**
   - `Calculator` 클래스를 활용해 연산을 수행하는 로직을 작성합니다.
   - 레벨 1의 프로그램 실행 흐름을 그대로 유지합니다.

4. **필드 캡슐화**
   - `Calculator` 클래스의 필드를 캡슐화합니다.
   - 필드에 접근하기 위해 `Getter`와 `Setter`를 제공합니다.
   - `Getter`와 `Setter`를 활용하는 로직을 작성합니다.

5. **연산 결과 삭제 기능**
   - `Calculator` 클래스에 저장된 값 중 가장 먼저 저장된 값을 삭제하는 기능을 구현합니다.
   - 해당 기능을 사용하는 로직을 작성합니다.
  
<br>

### [LEVEL 3] Enum, Generic, Lambda를 적용한 계산기 만들기
1. **Enum을 사용한 연산자 타입 관리**
   - 연산자 타입을 `Enum`으로 정의하여 연산자에 대한 정보를 관리합니다.
   - `ArithmeticCalculator` 클래스에 `Enum`을 활용하여 연산자 타입을 처리합니다.

2. **Generic을 활용한 피연산자 타입 확장**
   - `ArithmeticCalculator` 클래스의 연산메서드에 `Generic`을 적용하여 다양한 타입의 피연산자를 처리할 수 있도록 확장합니다.

3. **Lambda와 Stream을 활용한 결과 필터링**
   - 저장된 연산 결과 중, 사용자가 입력한 기준 값보다 큰 값들을 조회하는 메서드를 추가합니다.
   - 이를 위해 `Lambda`와 `Stream`을 사용하여 필터링 작업을 수행합니다.
