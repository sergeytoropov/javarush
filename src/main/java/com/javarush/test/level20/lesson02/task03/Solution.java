package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<String, String>();

    public void fillInPropertiesMap() throws FileNotFoundException, IOException {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        Properties props = new Properties();
        props.load(new FileInputStream(filename));

        properties.clear();
        for (Map.Entry<Object, Object> prop: props.entrySet()) {
            properties.put((String) prop.getKey(), (String) prop.getValue());
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties props = new Properties();
        for (Map.Entry<String, String> prop: properties.entrySet()) {
            props.put(prop.getKey(), prop.getValue());
        }
        props.store(outputStream, "Class Properties.store");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties props = new Properties();
        props.load(inputStream);

        properties.clear();
        for (Map.Entry<Object, Object> prop: props.entrySet()) {
            properties.put((String) prop.getKey(), (String) prop.getValue());
        }
    }
}
