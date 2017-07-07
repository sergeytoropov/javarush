package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        ArrayList<String> list = new ArrayList<String>();


        File file = new File(filename);
        if (file.createNewFile()) {

            String s;
            while (true) {
                s = reader.readLine();
                if (s.equals("exit")) {
                    break;
                }
                list.add(s);
            }

            FileWriter fWriter = new FileWriter(filename);
            BufferedWriter writer = new BufferedWriter(fWriter);

            for (String line: list) {
                System.out.println(line);
                writer.write(line);
                //writer.newLine();
            }
            writer.flush();

            fWriter.close();
            writer.close();
        }

        reader.close();
    }
}
