package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human grandFather1 = new Human("дедушка Вася", true, 67);
        Human grandFather2 = new Human("дедушка Владимир", true, 70);

        Human grandMother1 = new Human("бабушка Рая", false, 68);
        Human grandMother2 = new Human("бабушка Наташа", false, 69);

        Human father = new Human("отец Сергей", true, 33);
        Human mother = new Human("мать Маша", false, 30);

        Human child1 = new Human("сын Иван", true, 12);
        Human child2 = new Human("дочь Мария", false, 9);
        Human child3 = new Human("сын Антошка", true, 3);

        grandFather1.addChild(father);
        grandMother1.addChild(father);

        grandFather2.addChild(mother);
        grandMother2.addChild(mother);

        father.addChild(child1);
        father.addChild(child2);
        father.addChild(child3);

        mother.addChild(child1);
        mother.addChild(child2);
        mother.addChild(child3);

        System.out.println(grandFather1);
        System.out.println(grandFather2);

        System.out.println(grandMother1);
        System.out.println(grandMother2);

        System.out.println(father);
        System.out.println(mother);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }

    public static class Human
    {
        //Написать тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<Human>();
        }

        public void addChild(Human child) {
            this.children.add(child);
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
