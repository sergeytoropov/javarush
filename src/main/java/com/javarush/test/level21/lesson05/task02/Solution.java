package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if (first != null) {
            hash += first.length();
        }
        if (last != null) {
            hash += last.length();
        }
        return hash;
    }

    private boolean equalsStr(String s1, String s2) {
        boolean result = true;

        if (s1 == s2 && s1 == null) {
            result = result && true;
        } else if (s1 != null) {
            result = result && s1.equals(s2);
        } else {
            result = result && false;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Solution))
            return false;
        Solution n = (Solution) obj;
        return equalsStr(first, n.first) && equalsStr(last, n.last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<Solution>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
