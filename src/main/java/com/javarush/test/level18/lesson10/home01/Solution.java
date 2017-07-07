package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: Solution filename");
            return;
        }

        try {
            FileInputStream stream = new FileInputStream(args[0]);
            int counter = 0;
            while (stream.available() > 0) {
                int b = stream.read();
                if (b >= 0x41 && b <= 0x5A || b >= 0x61 && b <= 0x7A) {
                    counter += 1;
                }
            }
            System.out.println(counter);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
