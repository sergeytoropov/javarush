package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        final char blank = ' ';

        if (string == null) {
            throw new TooShortStringException();
        }

        int begin = string.indexOf(blank);
        if (begin < 0) {
            throw new TooShortStringException();
        }

        int end = begin;
        for (int index = 0; index < 3; index++) {
            end = string.indexOf(blank, end + 1);
            if (end < 0) {
                throw new TooShortStringException();
            }
        }

        for (int index = end + 1; index < string.length(); index++) {
            if (" .,!?:;".indexOf(string.charAt(index)) >= 0) {
                return string.substring(begin + 1, index);
            }
        }

        return string.substring(begin + 1);
    }

    public static class TooShortStringException extends Exception {
    }
}
