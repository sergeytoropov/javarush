package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new MyPrintStream(baos));
        testString.printSomething();
        System.setOut(console);

        System.out.println(baos.toString());
        baos.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    public static class MyPrintStream extends PrintStream {
        private long counter = 1;

        private void ad() {
            counter += 1;
            if (counter % 3 == 0) {
                println("JavaRush - курсы Java онлайн");
            }
        }

        public MyPrintStream(OutputStream out)
        {
            super(out);
        }

        public MyPrintStream(OutputStream out, boolean autoFlush)
        {
            super(out, autoFlush);
        }

        public MyPrintStream(OutputStream out, boolean autoFlush, String encoding) throws UnsupportedEncodingException
        {
            super(out, autoFlush, encoding);
        }

        public MyPrintStream(String fileName) throws FileNotFoundException
        {
            super(fileName);
        }

        public MyPrintStream(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException
        {
            super(fileName, csn);
        }

        public MyPrintStream(File file) throws FileNotFoundException
        {
            super(file);
        }

        public MyPrintStream(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException
        {
            super(file, csn);
        }

        @Override
        public void println()
        {
            super.println();
            ad();

        }

        @Override
        public void println(boolean x)
        {
            super.println(x);
            ad();
        }

        @Override
        public void println(char x)
        {
            super.println(x);
            ad();
        }

        @Override
        public void println(int x)
        {
            super.println(x);
            ad();
        }

        @Override
        public void println(long x)
        {
            super.println(x);
            ad();
        }

        @Override
        public void println(float x)
        {
            super.println(x);
            ad();
        }

        @Override
        public void println(double x)
        {
            super.println(x);
            ad();
        }

        @Override
        public void println(char[] x)
        {
            super.println(x);
            ad();
        }

        @Override
        public void println(String x)
        {
            super.println(x);
            ad();
        }

        @Override
        public void println(Object x)
        {
            super.println(x);
            ad();
        }
    }
}
