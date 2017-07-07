package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution() {
    }

    public Solution(int a) {
    }

    public Solution(int a, int b) {
    }

    protected Solution(String s1) {
    }

    protected Solution(String s1, String s2) {
    }

    protected Solution(String s1, String s2, String s3) {
    }

    Solution(boolean b1) {
    }

    Solution(boolean b1, boolean b2) {
    }

    Solution(boolean b1, boolean b2, boolean b3) {
    }

    private Solution(short sh1) {
    }

    private Solution(short sh1, short sh2) {
    }

    private Solution(short sh1, short sh2, short sh3) {
    }
}

