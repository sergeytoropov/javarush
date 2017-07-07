package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endX) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static class Algorithm {
        private int[][] crossword;
        private List<String> words;
        private List<Word> answers = new ArrayList<Word>();

        public Algorithm(int[][] crossword, String... words) {
            this.crossword = crossword;
            this.words = Arrays.asList(words);
        }

        private boolean isNextChar(int x, int y, char ch) {
            if ((x >= 0 && x < crossword.length) && (y >= 0 && y < crossword[0].length)) {
                if (crossword[x][y] == ch) {
                    return true;
                }
            }
            return false;
        }

        private Word createWord(int endX, int endY, String keyWord, int pos) {
            Word word = null;
            if (pos == keyWord.length() - 1) {
                word = new Word(keyWord);
                word.setEndPoint(endX, endY);
            }
            return word;
        }

        public Word right(int x, int y, String keyWord, int pos) {
            Word word = null;

            if (isNextChar(x, y, keyWord.charAt(pos))) {
                word = createWord(x, y, keyWord, pos);
                if (word == null) {
                    word = right(x, y + 1, keyWord, pos + 1);
                }
            }
            return word;
        }

        public Word left(int x, int y, String keyWord, int pos) {
            Word word = null;

            if (isNextChar(x, y, keyWord.charAt(pos))) {
                word = createWord(x, y, keyWord, pos);
                if (word == null) {
                    word = left(x, y - 1, keyWord, pos + 1);
                }
            }
            return word;
        }

        public Word top(int x, int y, String keyWord, int pos) {
            Word word = null;

            if (isNextChar(x, y, keyWord.charAt(pos))) {
                word = createWord(x, y, keyWord, pos);
                if (word == null) {
                    word = top(x - 1, y, keyWord, pos + 1);
                }
            }
            return word;
        }

        public Word bottom(int x, int y, String keyWord, int pos) {
            Word word = null;

            if (isNextChar(x, y, keyWord.charAt(pos))) {
                word = createWord(x, y, keyWord, pos);
                if (word == null) {
                    word = bottom(x + 1, y, keyWord, pos + 1);
                }
            }
            return word;
        }

        public Word topRight(int x, int y, String keyWord, int pos) {
            Word word = null;

            if (isNextChar(x, y, keyWord.charAt(pos))) {
                word = createWord(x, y, keyWord, pos);
                if (word == null) {
                    word = topRight(x - 1, y + 1, keyWord, pos + 1);
                }
            }

            return word;
        }

        public Word topLeft(int x, int y, String keyWord, int pos) {
            Word word = null;

            if (isNextChar(x, y, keyWord.charAt(pos))) {
                word = createWord(x, y, keyWord, pos);
                if (word == null) {
                    word = topLeft(x - 1, y - 1, keyWord, pos + 1);
                }
            }

            return word;
        }

        public Word bottomRight(int x, int y, String keyWord, int pos) {
            Word word = null;

            if (isNextChar(x, y, keyWord.charAt(pos))) {
                word = createWord(x, y, keyWord, pos);
                if (word == null) {
                    word = bottomRight(x + 1, y + 1, keyWord, pos + 1);
                }
            }

            return word;
        }

        public Word bottomLeft(int x, int y, String keyWord, int pos) {
            Word word = null;

            if (isNextChar(x, y, keyWord.charAt(pos))) {
                word = createWord(x, y, keyWord, pos);
                if (word == null) {
                    word = bottomLeft(x + 1, y - 1, keyWord, pos + 1);
                }
            }

            return word;
        }

        private void addAnswer(Word word, int x, int y) {
            if (word != null) {
                word.setStartPoint(x, y);
                word.reverse();
                answers.add(word);
            }
        }

        public List<Word> run() {

            for (int x = 0; x < crossword.length; x++) {
                for (int y = 0; y < crossword[x].length; y++) {

                    for (String keyWord: words) {
                        if (crossword[x][y] == keyWord.charAt(0)) {

                            addAnswer(right(x, y, keyWord, 0), x, y);
                            addAnswer(left(x, y, keyWord, 0), x, y);
                            addAnswer(top(x, y, keyWord, 0), x, y);
                            addAnswer(bottom(x, y, keyWord, 0), x, y);
                            addAnswer(topRight(x, y, keyWord, 0), x, y);
                            addAnswer(topLeft(x, y, keyWord, 0), x, y);
                            addAnswer(bottomRight(x, y, keyWord, 0), x, y);
                            addAnswer(bottomLeft(x, y, keyWord, 0), x, y);
                        }
                    }
                }
            }

            return answers;
        }

        public List<Word> getAnswers() {
            return answers;
        }
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        Algorithm algorithm = new Algorithm(crossword, words);
        algorithm.run();
        return algorithm.getAnswers();
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }

        public String getText() {
            return text;
        }

        @Override
        public boolean equals(Object obj) {
            Word word = (Word) obj;
            return text.equals(word.text)
                    && startX == word.startX && startY == word.startY && endX == word.endX && endY == word.endY;
        }

        public void reverse() {
            int tmp;

            tmp    = startX;
            startX = startY;
            startY = tmp;

            tmp  = endX;
            endX = endY;
            endY = tmp;
        }
    }
}
