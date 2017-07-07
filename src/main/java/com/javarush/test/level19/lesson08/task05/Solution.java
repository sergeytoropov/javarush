package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String filename = reader.readLine();
            reader.close();

            PrintStream console = System.out;

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream stream = new PrintStream(baos);
            System.setOut(stream);

            testString.printSomething();

            System.setOut(console);
            stream.close();

            System.out.println(baos.toString());
            byte[] bites = baos.toByteArray();
            baos.close();

            FileOutputStream fos = new FileOutputStream(filename);
            for (int i = 0; i < bites.length; i++) {
                fos.write(bites[i]);
            }
            fos.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

