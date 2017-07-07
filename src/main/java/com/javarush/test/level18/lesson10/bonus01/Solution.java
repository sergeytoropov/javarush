package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    private static int magic = 7;
    private static String key = "";
    private static String fileName = "";
    private static String fileOutputName = "";

    private static void usage() {
        System.out.println("Usage: Solution -e | -d fileName fileOutputName");
        System.exit(0);
    }
    public static void main(String[] args) {
        if (args.length == 3) {
            key = args[0];
            fileName = args[1];
            fileOutputName = args[2];
            if ("-e".equals(key) || "-d".equals(key)) {
            } else {
                usage();
            }
        } else {
            usage();
        }

        if ("-e".equals(key)) {
            encode();
        } else if ("-d".equals(key)) {
            decode();
        }
    }

    public static void encode() {
        try {
            FileInputStream inputS = new FileInputStream(fileName);
            FileOutputStream outputS = new FileOutputStream(fileOutputName);

            while (inputS.available() > 0) {
                int b = inputS.read();
                if (b >= 0x20 && b <= 0x7E) {
                    b += magic;
                    if (b > 0x7E) {
                        b -= 0x5F;
                    }
                }
                outputS.write(b);
            }

            inputS.close();
            outputS.close();
        } catch (IOException e ) {
            System.out.println(e);
        }
    }
    public static void decode() {
        try {
            FileInputStream inputS = new FileInputStream(fileName);
            FileOutputStream outputS = new FileOutputStream(fileOutputName);

            while (inputS.available() > 0) {
                int b = inputS.read();
                if (b >= 0x20 && b <= 0x7E) {
                    b -= magic;
                    if (b < 0x20) {
                        b += 0x5F;
                    }
                }
                outputS.write(b);
            }

            inputS.close();
            outputS.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
