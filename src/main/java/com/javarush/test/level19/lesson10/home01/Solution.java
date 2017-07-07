package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static void usage() {
        System.out.println("Usage: Solution filename");
        System.exit(0);
    }

    private static String[] sort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    String tmpS = array[i];
                    array[i] = array[j];
                    array[j] = tmpS;
                }
            }
        }
        return array;
    }

    private static void print(HashMap<String, Double> map) {
        for (Map.Entry<String, Double> pair: map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    private static HashMap<String, Double> init(String filename) throws IOException {
        HashMap<String, Double> map = new HashMap<String, Double>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line;
        while ( (line = reader.readLine()) != null ) {
            String[] items = line.split(" ");
            if (map.get(items[0]) == null) {
                map.put(items[0], Double.parseDouble(items[1]));
            } else {
                map.put(items[0], map.get(items[0]) + Double.parseDouble(items[1]));
            }
        }
        reader.close();

        return map;
    }

    public static void main(String[] args) throws IOException
    {
        if (args.length != 1) {
            usage();
        }
        HashMap<String, Double> map = init(args[0]);

        String[] array = new String[map.size()];
        int idx = 0;
        for (Map.Entry<String, Double> pair: map.entrySet()) {
            array[idx] = pair.getKey();
            idx += 1;
        }

        array = sort(array);

        for (String item: array) {
            System.out.println(item + " " + map.get(item));
        }
    }
}
