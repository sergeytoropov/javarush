package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую половину.
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
       try {
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           String filename = reader.readLine();
           String name2 = reader.readLine();
           String name3 = reader.readLine();
           reader.close();

           FileInputStream stream = new FileInputStream(filename);

           int len2;
           int len3;
           if (stream.available() % 2 == 0) {
               len2 = len3 = stream.available() / 2;
           } else {
               len2 = len3 = (stream.available() + 1) / 2;
               len3 -= 1;
           }

           byte[] array2 = new byte[len2];
           byte[] array3 = new byte[len3];
           int size;

           size = stream.read(array2, 0, len2);
           FileOutputStream strm2 = new FileOutputStream(name2);
           strm2.write(array2);
           strm2.close();

           size = stream.read(array3, 0, len3);
           FileOutputStream strm3 = new FileOutputStream(name3);
           strm3.write(array3);
           strm3.close();

           stream.close();
       } catch (IOException e) {
       }
    }
}
