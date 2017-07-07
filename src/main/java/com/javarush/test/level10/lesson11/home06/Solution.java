package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

//import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class Solution
{
    public static void main(String[] args)
    {
        Human human = new Human("Sergey");
        System.out.println(human.firstname);
    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        public String firstname;
        private String lastname;
        private String middlename;
        private int age;
        private boolean sex;
        private boolean car;

        public Human(String firstname, String lastname, String middlename) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.middlename = middlename;
        }

        public Human(String firstname, String lastname, String middlename, boolean sex) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.middlename = middlename;
            this.sex = sex;
        }

        public Human(String firstname, String lastname, String middlename, int age) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.middlename = middlename;
            this.age = age;
        }

        public Human(String firstname, String lastname, String middlename, int age, boolean sex) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.middlename = middlename;
            this.age = age;
            this.sex = sex;
        }

        public Human(String firstname, String lastname, String middlename, int age, boolean sex, boolean car) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.middlename = middlename;
            this.age = age;
            this.sex = sex;
            this.car = car;
        }

        public Human(String firstname) {
            this.firstname = firstname;
        }

        public Human(String firstname, int age) {
            this.firstname = firstname;
            this.age = age;
        }

        public Human(String firstname, int age, boolean sex) {
            this.firstname = firstname;
            this.age = age;
            this.sex = sex;
        }

        public Human(String firstname, int age, boolean sex, boolean car) {
            this.firstname = firstname;
            this.age = age;
            this.sex = sex;
            this.car = car;
        }

        public Human(String firstname, String lastname, int age) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.age = age;
        }
    }
}
