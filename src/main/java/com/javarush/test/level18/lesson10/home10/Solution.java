package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {

    private static String nextFile(ArrayList<String> list, String postfix) {
        for (String name: list) {
            if (name.endsWith(postfix)) {
                return name;
            }
        }
        return null;
    }

    private static void glue(String fileName, String fileNamePart, boolean append) throws IOException {
        FileOutputStream outputS = new FileOutputStream(fileName, append);
        FileInputStream inputS = new FileInputStream(fileNamePart);

        byte[] buffer = new byte[inputS.available()];
        inputS.read(buffer);

        outputS.write(buffer);

        inputS.close();
        outputS.close();
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        try {
            while (true) {
                String s = reader.readLine();
                if ("end".equals(s)) {
                    break;
                }
                list.add(s);
            }
            reader.close();

            int idx  = 0;
            boolean append = false;
            while (true) {
                idx += 1;
                String postfix = ".part" + idx;
                String fileNamePart = nextFile(list, postfix);
                if (fileNamePart == null) {
                    break;
                }
                String fileName = fileNamePart.substring(0, fileNamePart.lastIndexOf(postfix));
                glue(fileName, fileNamePart, append);
                append = true;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
