package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fname1 = reader.readLine();
            String fname2 = reader.readLine();
            String fname3 = reader.readLine();
            reader.close();

            FileOutputStream stream1;
            stream1 = new FileOutputStream(fname1);

            FileInputStream stream2 = new FileInputStream(fname2);
            while (stream2.available() > 0) {
                stream1.write(stream2.read());
            }
            stream1.close();
            stream2.close();

            stream1 = new FileOutputStream(fname1, true);
            FileInputStream stream3 = new FileInputStream(fname3);
            while (stream3.available() > 0) {
                stream1.write(stream3.read());
            }
            stream1.close();
            stream3.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
