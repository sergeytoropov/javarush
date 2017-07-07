package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть все потоки ввода-вывода
2.2 выбросить исключение DownloadException
*/

import java.io.*;
import java.nio.BufferUnderflowException;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                FileInputStream stream = new FileInputStream(reader.readLine());
                if (stream.available() < 1000) {
                    stream.close();
                    throw new DownloadException();
                }
                stream.close();
            }

        } catch (IOException e) {
        }

    }

    public static class DownloadException extends Exception{

    }
}
