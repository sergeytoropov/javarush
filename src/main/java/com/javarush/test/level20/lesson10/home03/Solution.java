package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution implements Serializable {
    //private static final long serialVersionUID = 111222333L;

    public static class A {
        protected String name = "A";

        public A() {}

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        //private static final long serialVersionUID = 111222333L;

        public B(String name) {
            super(name);
            this.name += name;
        }

        @Override
        public String toString() {
            return "B{} : " + this.name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.writeObject(this.name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            this.name = (String) in.readObject();
        }
    }
}
