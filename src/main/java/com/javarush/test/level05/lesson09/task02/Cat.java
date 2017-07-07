package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //Напишите тут ваш код
    private String name;
    private int widht;
    private int age;
    private String color;
    private String address;

    public Cat(String name)
    {
        this.name = name;
    }

    public Cat(String name, int widht, int age)
    {
        this.name = name;
        this.widht = widht;
        this.age = age;
    }

    public Cat(String name, int age)
    {
        this.name = name;
        this.age = age;
        this.widht = 2;
    }

    public Cat(int widht, String color)
    {
        this.widht = widht;
        this.color = color;
    }

    public Cat(int widht, String color, String address)
    {
        this.widht = widht;
        this.color = color;
        this.address = address;
    }
}
