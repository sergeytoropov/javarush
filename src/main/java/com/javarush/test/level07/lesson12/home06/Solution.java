package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей.
Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human,
то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human grandFather1 = new Human("Николай", true, 67);
        Human grandFather2 = new Human("Василий", true, 70);

        Human grandMother1 = new Human("Рая", false, 68);
        Human grandMother2 = new Human("Маша", false, 69);

        Human father = new Human("Сергей", true, 35, grandFather1, grandMother1);
        Human mother = new Human("Катя", false, 32, grandFather2, grandMother2);

        Human sun1 = new Human("Иван", true, 11, father, mother);
        Human sun2 = new Human("Егор", true, 8, father, mother);
        Human sun3 = new Human("Петр", true, 3, father, mother);

        System.out.println(grandFather1);
        System.out.println(grandFather2);

        System.out.println(grandMother1);
        System.out.println(grandMother2);

        System.out.println(father);
        System.out.println(mother);

        System.out.println(sun1);
        System.out.println(sun2);
        System.out.println(sun3);

    }

    public static class Human
    {
        //Написать тут ваш код
        private String name;
        private boolean sex; //true - father, false - mother
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
