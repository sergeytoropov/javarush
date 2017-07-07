package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        ArrayList<Integer> list = new ArrayList<Integer>();

        File file = new File(filename);
        if (file.exists()) {
            FileReader fReader = new FileReader(filename);
            BufferedReader fileReader = new BufferedReader(fReader);

            String s;
            while ((s = fileReader.readLine()) != null) {
                Integer d = Integer.parseInt(s);
                if ( d % 2 == 0) {
                    list.add(d);
                }
            }
        }

        int index = 0;
        int[] array = new int[list.size()];
        for (int digit: list) {
            array[index] = digit;
            index += 1;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
