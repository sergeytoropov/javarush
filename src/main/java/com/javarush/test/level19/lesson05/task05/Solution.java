package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fName1 = reader.readLine();
            String fName2 = reader.readLine();
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fName2));
            reader = new BufferedReader(new FileReader(fName1));
            String tmpS;
            while ( (tmpS = reader.readLine()) != null ) {
                writer.write(tmpS.replaceAll("\\p{Punct}", ""));
                writer.newLine();
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
