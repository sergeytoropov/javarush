package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор.
Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12/*высота, см*//* , 5 /*длина хвоста, см *//*)
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);

        //Напишите тут ваш код
        Mouse smallMouse = new Mouse("Small", 10, 4);
        Dog bigDog = new Dog("Big", 32, 7);
        Dog smallDog = new Dog("Small", 15, 6);
        Cat tomCat = new Cat("Tom", 28, 7);
        Cat ledyCat = new Cat("Ledy", 26, 6);
        Cat bomzhCat = new Cat("Bomzh", 30, 8);
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //Напишите тут ваши классы
    public static class Dog
    {
        String name;
        int heigth;
        int tail;

        public Dog(String name, int heigth, int tail)
        {
            this.name = name;
            this.heigth = heigth;
            this.tail = tail;
        }
    }

    public static class Cat
    {
        String name;
        int heigth;
        int tail;

        public Cat(String name, int heigth, int tail)
        {
            this.name = name;
            this.heigth = heigth;
            this.tail = tail;
        }
    }
}