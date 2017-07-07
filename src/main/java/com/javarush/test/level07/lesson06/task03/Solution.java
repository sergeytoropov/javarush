package com.javarush.test.level07.lesson06.task03;

/* 5 строчек в обратном порядке
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в него.
3. Расположи их в обратном порядке.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();

        int i = 0;
        while (true) {
            if (i > 4)
                break;
            list.add(reader.readLine());
            i++;
        }

        int start = 0, end = list.size() - 1;
        while ((end - start) > 0) {
            String temp = list.get(end);
            list.set(end, list.get(start));
            list.set(start, temp);
            start++;
            end--;
        }

        i = 0;
        while (i < list.size()) {
            System.out.println(list.get(i));
            i++;
        }
    }
}
