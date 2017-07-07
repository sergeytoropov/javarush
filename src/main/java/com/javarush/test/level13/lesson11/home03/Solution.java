package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        File file = new File(filename);
        if (file.isFile()) {

            FileReader fReader = new FileReader(filename);
            BufferedReader fileReader = new BufferedReader(fReader);

            String s;
            while ((s = fileReader.readLine()) != null) {
                System.out.println(s);
            }

            fileReader.close();
            fReader.close();
        }
        reader.close();
    }
}
