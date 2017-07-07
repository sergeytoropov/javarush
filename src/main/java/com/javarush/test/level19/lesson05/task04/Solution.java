package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
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

            FileReader fReader = new FileReader(fName1);
            FileWriter fWriter = new FileWriter(fName2);
            while (fReader.ready()) {
                int ch = fReader.read();
                if (ch == '.') {
                    ch = '!';
                }
                fWriter.write(ch);
            }
            fReader.close();
            fWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
