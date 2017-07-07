package com.javarush.test.level20.lesson02.task05;

import java.io.*;
import java.util.Properties;

/* И еще раз о синхронизации
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4


            loadedObject.load(inputStream);
            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            Properties props = new Properties();
            props.put("string1", "" + string1.getNumber());
            props.put("string2", "" + string2.getNumber());
            props.store(outputStream, "level20.lesson02.task05");
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            Properties props = new Properties();
            props.load(inputStream);

            string1 = String.duplicate(Integer.parseInt(props.getProperty("string1")));
            string2 = String.duplicate(Integer.parseInt(props.getProperty("string2")));
        }

        @Override
        public boolean equals(java.lang.Object obj) {
            Object object = (Object) obj;
            return string1.equals(object.string1) && string2.equals(object.string2);
        }
    }

    public static int countStrings;

    public static class String {
        private final int number;

        private String(int number) {
            this.number = number;
        }

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }

        @Override
        public boolean equals(java.lang.Object obj) {
            String string = (String) obj;
            return number == string.number;
        }

        @Override
        public java.lang.String toString() {
            return "string #" + number;
        }

        public String duplicate() {
            return new String(number);
        }

        public static String duplicate(int number) {
            return new String(number);
        }

        public int getNumber() {
            return number;
        }
    }
}
