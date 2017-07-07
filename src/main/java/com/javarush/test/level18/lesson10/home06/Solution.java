package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        String filename = "";
        if (args.length == 1) {
            filename = args[0];
        } else {
            System.out.println("Usage: Solution filename");
            return;
        }

        long[] accii = new long[Byte.MAX_VALUE];
        for (int i = 0; i < accii.length; i++) {
            accii[i] = 0;
        }

        try {
            FileInputStream stream = new FileInputStream(filename);
            while (stream.available() > 0) {
                int b = stream.read();
                if (b > 0 && b <= Byte.MAX_VALUE) {
                    accii[b] += 1;
                }
            }
            stream.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        for (int i = 0; i < accii.length; i++) {
            if (accii[i] > 0) {
                System.out.println((char) i  + " " + accii[i]);
            }
        }
    }
}
