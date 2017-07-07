package com.javarush.test.level18.lesson08.task03;

import java.io.*;
import java.nio.channels.FileChannel;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream stream;

    public AmigoOutputStream(FileOutputStream stream) {
        this.stream = stream;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));

    }

    public AmigoOutputStream(String name) throws FileNotFoundException
    {
        this.stream = new FileOutputStream(name);
    }

    public AmigoOutputStream(String name, boolean append) throws FileNotFoundException
    {
        this.stream = new FileOutputStream(name, append);
    }

    public AmigoOutputStream(File file) throws FileNotFoundException
    {
        this.stream = new FileOutputStream(file);
    }

    public AmigoOutputStream(File file, boolean append) throws FileNotFoundException
    {
        this.stream = new FileOutputStream(file, append);
    }

    public AmigoOutputStream(FileDescriptor fdObj)
    {
        this.stream = new FileOutputStream(fdObj);
    }

    public void write(int b) throws IOException
    {
        stream.write(b);
    }

    public void write(byte[] b) throws IOException
    {
        stream.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException
    {
        stream.write(b, off, len);
    }

    public FileChannel getChannel()
    {
        return stream.getChannel();
    }

    public void close() throws IOException {
        stream.flush();
        stream.write("JavaRush © 2012-2013 All rights reserved.".getBytes());
        stream.close();
    }

}

