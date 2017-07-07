package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename;
        while (true) {
            filename = reader.readLine();
            try {
                FileReader r = new FileReader(filename);
                r.close();
            } catch (FileNotFoundException e) {
                reader.close();

                System.out.println(filename);
                break;
            }
        }
    }
}
