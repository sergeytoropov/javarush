package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        String filenameUpdated = reader.readLine();
        reader.close();

        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> listUpdated = new ArrayList<String>();

        String s;
        reader = new BufferedReader(new FileReader(filename));
        while ( (s = reader.readLine()) != null) {
            list.add(s);
        }
        reader.close();

        reader = new BufferedReader(new FileReader(filenameUpdated));
        while ( (s = reader.readLine()) != null) {
            listUpdated.add(s);
        }
        reader.close();

        // Алгоритм
        algorithm(list, listUpdated);

        for (LineItem line: lines) {
            String decs = "";
            switch (line.type) {
                case ADDED:
                    decs = "ADDED";
                    break;
                case REMOVED:
                    decs = "REMOVED";
                    break;
                case SAME:
                    decs = "SAME";
                    break;
            }
            System.out.println(decs + " " + line.line);
        }

    }

    public static void algorithm(ArrayList<String> list, ArrayList<String> listUpdated) {
        final int constExit    = 0;
        final int constSame    = 1;
        final int constRemoved = 2;
        final int constAdded   = 3;
        int state;
        int position = 0;

        for (String item: listUpdated)
        {
            state = constSame;
            if (position >= list.size())
            {
                state = constAdded;
            }

            boolean isContinued = true;
            while (isContinued)
            {
                switch (state)
                {
                    case constExit:
                        isContinued = false;
                        break;

                    case constSame:
                        state = constRemoved;
                        if (item.equals(list.get(position)))
                        {
                            lines.add(new LineItem(Type.SAME, item));
                            position += 1;
                            state = constExit;
                        }
                        break;

                    case constRemoved:
                        state = constAdded;
                        ArrayList<String> tmpList = new ArrayList<String>();
                        for (int i = position; i < list.size(); i++)
                        {
                            if (item.equals(list.get(i)))
                            {
                                position = i;
                                for (String tmpS : tmpList)
                                {
                                    lines.add(new LineItem(Type.REMOVED, tmpS));
                                }

                                lines.add(new LineItem(Type.SAME, item));
                                position += 1;

                                state = constExit;
                                break;
                            } else
                            {
                                tmpList.add(list.get(i));
                            }
                        }
                        break;

                    case constAdded:
                        lines.add(new LineItem(Type.ADDED, item));
                        //position += 1;
                        state = constExit;
                        break;
                }
            }
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
