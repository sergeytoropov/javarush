package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Пример ввода:
мама     мыла раму.
Пример вывода:
Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //Напишите тут ваш код
        String[] worlds = s.split(" ");
        for (int i = 0; i < worlds.length; i++) {
            if (worlds[i].length() > 0) {
                char upperCase = worlds[i].toUpperCase().toCharArray()[0];
                char[] word = worlds[i].toCharArray();

                String newS = "";
                for (int j = 0; j < word.length; j++)
                    if (j == 0)
                        newS += upperCase;
                    else
                        newS += word[j];

                worlds[i] = newS;
            }
        }

        String result = "";
        for (int i = 0; i < worlds.length; i++)
            result = result + worlds[i] + " ";

        System.out.println(result);
    }


}
