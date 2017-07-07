package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
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

            int idx = 1;
            while (fReader.ready()) {
                if (idx % 2 == 0) {
                    fWriter.write(fReader.read());
                } else {
                    int ch = fReader.read();
                }
                idx += 1;
            }
            fReader.close();
            fWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
