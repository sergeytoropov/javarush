package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            try {
                String fName1 = reader.readLine();
                String fName2 = reader.readLine();

                readFile(fName1, allLines);
                readFile(fName2, forRemoveLines);
            } finally {
                reader.close();
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException cde) {
        } catch (IOException ioe) {
        }
    }

    public static void clear() {
        allLines.clear();
        forRemoveLines.clear();
    }

    public static void readFile(String fName, List<String> list) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fName));

            try {
                String line;
                while ((line = reader.readLine()) != null) {
                   list.add(line);
                }
            } finally {
                reader.close();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        }
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
