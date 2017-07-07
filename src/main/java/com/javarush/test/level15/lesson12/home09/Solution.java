package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        final int stateExit = 1;
        final int stateAddress = 2;
        final int stateVariable = 3;
        final int stateValue = 4;
        final int stateSave = 5;

        final char chQuestion = '?';
        final char chEqual = '=';
        final char chAmpersand = '&';

        ArrayList<String> vars = new ArrayList<String>();
        ArrayList<String> vals = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            char[] url = reader.readLine().toCharArray();
            reader.close();

            String address = "";
            String variable = "";
            String value = "";
            int state = stateAddress;

            for (int pos = 0; pos < url.length; pos++) {
                switch (state) {
                    case stateAddress:
                        if (url[pos] == chQuestion) {
                            state = stateVariable;
                        } else {
                            address = address + url[pos];
                        }
                        break;

                    case stateVariable:
                        if (url[pos] == chEqual) {
                            state = stateValue;
                        } else if (url[pos] == chAmpersand) {
                            state = stateSave;
                        } else if (pos == url.length-1) {
                            state = stateSave;
                            variable = variable + url[pos];
                        } else {
                            variable = variable + url[pos];
                        }
                        break;

                    case stateValue:
                        if (url[pos] == chAmpersand) {
                            state = stateSave;
                        } else if (pos == url.length-1) {
                            state = stateSave;
                            value = value + url[pos];
                        } else {
                            value = value + url[pos];
                        }
                        break;
                }

                if (state == stateSave) {
                    state = stateVariable;

                    vars.add(variable);
                    if ("obj".equals(variable)) {
                        vals.add(value);
                    }
                    variable = "";
                    value = "";
                }
            }

            for (String s: vars) {
                System.out.print(s + " ");
            }
            System.out.println();

            for (String s: vals) {
                try {
                    double dbl = Double.parseDouble(s);
                    alert(dbl);
                } catch (NumberFormatException e) {
                    alert(s);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
