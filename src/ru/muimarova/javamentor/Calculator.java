package ru.muimarova.javamentor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите выражение:");
        Expression inExpression = null;
        try {
            inExpression = new Expression(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (inExpression != null) {
            System.out.println(inExpression.calculate());
        }
    }
}
