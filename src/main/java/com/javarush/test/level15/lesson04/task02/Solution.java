package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
        printMatrix((Integer) m, n, value);
    }

    public static void printMatrix(Integer m, int n, Object value) {
        System.out.println("printMatrix (Integer, int, Object)");
        printMatrix((int) m, (Integer) n, value);
    }

    public static void printMatrix(int m, Integer n, Object value) {
        System.out.println("printMatrix (int, Integer, Object)");
        printMatrix((Integer) m, n, value);
    }

    public static void printMatrix(Integer m, Integer n, Object value) {
        System.out.println("printMatrix (Integer, Integer, Object)");
        printMatrix(m, (int) n, (String) value);
    }

    public static void printMatrix(Integer m, int n, String value) {
        System.out.println("printMatrix (Integer, int, String)");
        printMatrix((int) m, (Integer) n, value);
    }

    public static void printMatrix(int m, Integer n, String value) {
        System.out.println("printMatrix (int, Integer, String)");
        printMatrix((Integer) m, n, value);
    }

    public static void printMatrix(Integer m, Integer n, String value) {
        System.out.println("printMatrix (Integer, Integer, String)");
        printMatrix(value, m, n);
    }

    public static void printMatrix(String value, Integer m, Integer n) {
        System.out.println("printMatrix (String, Integer, Integer)");
        printMatrix(value, (int) m, (int) n);
    }

    public static void printMatrix(String value, int m, int n) {
        System.out.println("printMatrix (String, int, int)");
    }
}
