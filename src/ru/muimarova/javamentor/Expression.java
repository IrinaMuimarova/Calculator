package ru.muimarova.javamentor;

public class Expression {
    private static final String ILLEGAL_EXPRESSION = "Выражение не соответствует требуемому формату. Убедитесь что вы ввели в формате число1+число2. Числа не должны превышать 10.";

    private String str;

    public Expression(String str) {
        this.str = str;
    }

    public String calculate() {
        str = str.toUpperCase();
        if (str.charAt(0) == 'I' || str.charAt(0) == 'V' || str.charAt(0) == 'X') {
            int result = this.parseRomanNumerical().calculate();
            return convertToRomanNumerical(result);
        }

        if (Character.isDigit(str.charAt(0))) {
            return String.valueOf(this.parseArabicNumerical().calculate());
        } else {
            throw new IllegalArgumentException(ILLEGAL_EXPRESSION);
        }
    }

    private ru.muimarova.javamentor.CalculatorExpression parseRomanNumerical() {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                String stringNumber1 = str.substring(0, i);
                int number1 = convertRomanToNumber(stringNumber1);

                char operator = str.charAt(i);

                String stringNumber2 = str.substring(i + 1);
                int number2 = convertRomanToNumber(stringNumber2);

                return new CalculatorExpression(number1, number2, operator);
            }
        }
        throw new IllegalArgumentException(ILLEGAL_EXPRESSION);
    }

    private CalculatorExpression parseArabicNumerical() {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                try {
                    int number1 = Integer.parseInt(str.substring(0, i));
                    int number2 = Integer.parseInt(str.substring(i + 1));
                    char operator = str.charAt(i);

                    return new CalculatorExpression(number1, number2, operator);
                } catch (IllegalArgumentException e) {
                    System.out.println(ILLEGAL_EXPRESSION);
                }
            }
        }
        throw new IllegalArgumentException(ILLEGAL_EXPRESSION);
    }

    private int convertRomanToNumber(String number) {
        switch (number) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new IllegalArgumentException("Число не соответствует первым десяти римским числам");
        }
    }

    private static String convertToRomanNumerical(int number) {
        String string = "";
        if(number < 0){
            string = string + "-";
            number = Math.abs(number);
        }
        if (number == 0) {
            return "0";         //так как в римских цифрах 0 не было, то для данной задачи заменим его арабским.
        }

        if (number % 100 == 0) {
            return "C";
        }

        if (number / 50 > 0) {
            string = string + "L";
            number = number % 50;
        }

        if (number / 10 > 0) {
            int temp = number / 10;
            for (int i = 0; i < temp; i++) {
                string = string + "X";
            }
            number = number % 10;
        }

        if (number != 0) {
            switch (number) {
                case 1:
                    return string + "I";
                case 2:
                    return string + "II";
                case 3:
                    return string + "III";
                case 4:
                    return string + "IV";
                case 5:
                    return string + "V";
                case 6:
                    return string + "VI";
                case 7:
                    return string + "VII";
                case 8:
                    return string + "VIII";
                case 9:
                    return string + "IX";
            }
        }
        return string;
    }
}