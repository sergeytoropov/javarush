package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName1;
        String fName2;
        try {
            fName1 = reader.readLine();
            fName2 = reader.readLine();
            reader.close();

            reader = new BufferedReader(new FileReader(fName1));
            String[] items = reader.readLine().split(" ");
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fName2));
            for (String item: items) {
                if (!"".equals(item)) {
                    Double digit = Double.parseDouble(item);
                    writer.write(Math.round(digit) + " ");
                }
            }
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
