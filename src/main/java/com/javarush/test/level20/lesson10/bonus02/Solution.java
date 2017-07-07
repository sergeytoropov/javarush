package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static class Solve {
        private byte[][] a;

        public Solve(byte[][] a) {
            this.a = a;
        }

        private void clearRectangle(int startI, int startJ) {
            int endJ = a[startI].length;
            int j;

            for (int i = startI; i < a.length; i++) {
                if (a[i][startJ] == 0) {
                    break;
                }
                for (j = startJ; j < endJ; j++) {
                    if (a[i][j] > 0) {
                        a[i][j] = 0;
                    } else {
                        break;
                    }
                }
                endJ = j + 1;
                if (endJ > a[startI].length) {
                    endJ = a[startI].length;
                }
            }
        }

        public boolean nextRectangle() {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    if (a[i][j] > 0) {
                        clearRectangle(i, j);
                        return true;
                    }
                }
            }
            return false;
        }

        public byte[][] getA() {
            return a;
        }
    }

    public static int getRectangleCount(byte[][] a) {
        Solve solve = new Solve(a);
        int counter = 0;
        while (solve.nextRectangle()) {
            counter++;
        }
        return counter;
    }
}
