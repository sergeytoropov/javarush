package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            try {
                while (true) {
                    String fileName = reader.readLine();
                    if ("exit".equals(fileName)) {
                        break;
                    }
                    Thread thread = new ReadThread(fileName);
                    thread.start();
                    thread.join();
                }
            } finally {
                reader.close();
            }
        } catch (IOException ioe) {
        } catch (InterruptedException ie) {
        }
    }

    public static class ReadThread extends Thread {
        public String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            super();
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream reader = new FileInputStream(fileName);
                try {
                    Map<Integer, Integer> table = new HashMap<Integer, Integer>();
                    Integer code;

                    while ((code = reader.read()) != -1) {
                       if (table.containsKey(code)) {
                           table.put(code, table.get(code) + 1);
                       } else {
                           table.put(code, 1);
                       }
                    }

                    if (table.size() > 0) {
                        Integer key = 0;
                        Integer value = Integer.MIN_VALUE;
                        boolean isFirstItem = true;

                        for (Map.Entry<Integer, Integer> item: table.entrySet()) {
                            if (isFirstItem) {
                                isFirstItem = false;

                                key = item.getKey();
                                value = item.getValue();
                            } else {
                                if (value < item.getValue()) {
                                    key = item.getKey();
                                    value = item.getValue();
                                }
                            }
                        }

                        synchronized (resultMap) {
                            resultMap.put(fileName, key);
                        }
                    }
                } finally {
                    reader.close();
                }
            } catch (FileNotFoundException fnfe) {
            } catch (IOException ioe) {
            }
            //System.out.println("Thread = [" + Thread.currentThread().getName() + "] fName = " + fileName + ", byte = " + String.valueOf(Character.toChars(resultMap.get(fileName))));
        }
    }
}
