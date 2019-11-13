package ru.muimarova.javamentor;

class CalculatorExpression {
    private int number1;
    private int number2;
    private char operation;

    CalculatorExpression(int number1, int number2, char operation) {
        if (number1 > 10 || number2 > 10) {
            throw new IllegalArgumentException("Числа не должны быть больше 10");
        }
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    int calculate() {
        switch (operation) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '/':
                return number1 / number2;
            default:
                throw new IllegalArgumentException("Введен неверный оператор");
        }
    }
}
