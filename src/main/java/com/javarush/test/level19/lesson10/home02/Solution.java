package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма. Имена разделять пробелом
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private static void usage() {
        System.out.println("Usage: Solution filename");
        System.exit(0);
    }

    private static HashMap<String, Double> init(String filename) throws IOException {
        HashMap<String, Double> map = new HashMap<String, Double>();

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String tmpS;
        while ( (tmpS = reader.readLine()) != null ) {
            Scanner scanner = new Scanner(tmpS);
            map.put(scanner.next(), Double.parseDouble(scanner.next()));
        }
        reader.close();

        return map;
    }

    private static void print(HashMap<String, Double> map) {
        for (Map.Entry<String, Double> pair: map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    private static void print(HashMap<String, Double> map, double max) {
        for (Map.Entry<String, Double> pair: map.entrySet()) {
            if (pair.getValue() == max) {
                System.out.print(pair.getKey() + " ");
            }
        }
    }

    private static double max(HashMap<String, Double> map) {
        double max = Double.MIN_VALUE;

        for (Map.Entry<String, Double> pair: map.entrySet()) {
            if (max < pair.getValue()) {
                max = pair.getValue();
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            usage();
        }
        HashMap<String, Double> map = init(args[0]);
        double max = max(map);
        print(map, max);
    }
}
