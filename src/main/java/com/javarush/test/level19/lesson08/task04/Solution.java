package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baos);
        System.setOut(stream);

        testString.printSomething();

        System.setOut(console);

        String result = baos.toString();

        Scanner scanner = new Scanner(result);
        if (scanner.hasNext()) {
            result = scanner.nextLine();
            result += calculator(result);
        }
        scanner.close();

        System.out.println(result);

        stream.close();
        baos.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }

    public static int calculator(String expr) {
        String e = expr.replaceAll(" ", "");
        int op1 = 0;
        int op2 = 0;
        char operation = '+';

        String s = "";
        for (int i = 0; i < e.length(); i++) {
            char ch = e.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                op1 = Integer.parseInt(s);
                s = "";
                operation = ch;
            } else if (ch == '=') {
                op2 = Integer.parseInt(s);
                s = "";
            } else {
                s += String.valueOf(ch);
            }
        }

        int result = 0;
        if (operation == '+') {
            result = op1 + op2;
        } else if (operation == '-') {
            result = op1 - op2;
        } else {
            result = op1 * op2;
        }
        return result;
    }
}

