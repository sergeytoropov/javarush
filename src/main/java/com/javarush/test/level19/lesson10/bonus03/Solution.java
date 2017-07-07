package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;

public class Solution {
    public static String html = null;
    public static String fName = null;
    public static String tagName = null;

    public static void readFileName() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            try {
                fName = reader.readLine();
            } finally {
                reader.close();
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static String htmlFileToString() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fName));
            try {
                StringBuffer sb = new StringBuffer();
                String line = null;

                while ((line = reader.readLine()) != null) {
                   sb.append(line);
                }
                return sb.toString();
            } finally {
                reader.close();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return null;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.exit(1);
        }
        tagName = args[0];

        readFileName();
        html = htmlFileToString();
    }
}
