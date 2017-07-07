package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fname1 = reader.readLine();
            String fname2 = reader.readLine();
            reader.close();

            FileInputStream streamR = new FileInputStream(fname1);
            FileOutputStream streamW = new FileOutputStream(fname2);

            byte[] array = new byte[streamR.available()];
            streamR.read(array);

            for (int i = array.length; i > 0; i--) {
                streamW.write(array[i-1]);
            }

            streamR.close();
            streamW.close();
        } catch (IOException e) {
        }
    }
}
