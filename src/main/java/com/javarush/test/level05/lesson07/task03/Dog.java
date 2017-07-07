package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //Напишите тут ваш код
    private String name;
    private int heigth;
    private String color;

    public void initialize(String name)
    {
        this.name = name;
    }

    public void initialize(String name, int heigth)
    {
        this.name = name;
        this.heigth = heigth;
    }

    public void initialize(String name, int heigth, String color)
    {
        this.name = name;
        this.heigth = heigth;
        this.color = color;
    }
}
