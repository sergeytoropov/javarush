package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static ArrayList<String> words = new ArrayList<String>();

    private static void usage() {
        System.out.println("Usage: Solution filename1 filename2");
        System.exit(0);
    }

    private static void search(String filename) throws IOException {
        Scanner scanner = new Scanner(new FileReader(filename));
        String digits = "0123456789";
        while (scanner.hasNext()) {
            String word = scanner.next();
            for (int idx = 0; idx < digits.length(); idx++) {
                if (word.indexOf(digits.charAt(idx)) > -1) {
                    words.add(word);
                    break;
                }
            }
        }
        scanner.close();
    }

    private static void save(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (String word: words) {
            writer.write(word + " ");
        }
        writer.close();
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            usage();
        }
        String fName1 = args[0];
        String fName2 = args[1];

        try {
            search(fName1);
            save(fName2);
        } catch (IOException e) {
        }
    }
}
