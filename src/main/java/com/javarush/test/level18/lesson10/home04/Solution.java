package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fName1 = reader.readLine();
            String fName2 = reader.readLine();
            reader.close();

            FileInputStream inputS;

            inputS = new FileInputStream(fName1);
            byte[] tmpFile = new byte[inputS.available()];
            int countRead = inputS.read(tmpFile);
            inputS.close();

            FileOutputStream outputS = new FileOutputStream(fName1);

            inputS = new FileInputStream(fName2);
            while (inputS.available() > 0) {
                int b = inputS.read();
                outputS.write(b);
            }
            inputS.close();

            for (int i = 0; i < tmpFile.length; i++) {
                outputS.write(tmpFile[i]);
            }

            outputS.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
