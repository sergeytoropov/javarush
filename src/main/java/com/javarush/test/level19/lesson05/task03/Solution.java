package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fName1 = reader.readLine();
            String fName2 = reader.readLine();
            reader.close();

            FileWriter writer = new FileWriter(fName2);

            Scanner scanner = new Scanner(new FileReader(fName1));
            while (scanner.hasNext()) {
                try {
                    writer.write(Integer.parseInt(scanner.next()) + " ");
                } catch (NumberFormatException e) {
                }
            }
            scanner.close();

            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
