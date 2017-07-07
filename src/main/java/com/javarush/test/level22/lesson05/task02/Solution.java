package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        final int tab = '\t';

        if (string == null) {
            throw new TooShortStringException();
        }

        int begin = string.indexOf(tab);
        if (begin < 0) {
            throw new TooShortStringException();
        }

        int end = string.indexOf(tab, begin + 1);
        if (end < 0) {
            throw new TooShortStringException();
        }

        return string.substring(begin + 1, end);
    }

    public static class TooShortStringException extends Exception {
    }
}
