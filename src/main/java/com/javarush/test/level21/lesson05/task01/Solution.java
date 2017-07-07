package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
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
        String name = "";
        if (last != null) {
            if (last.length() >= 3) {
                name += last.substring(0, 3);
            }
        }
        if (first != null) {
            if (first.length() >= 1) {
                name += first.substring(0, 1);
            }
        }
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Solution s = (Solution) obj;

        boolean result = true;
        if (first == s.first && first == null) {
            result = result && true;
        } else if (first != null) {
            result = result && first.equals(s.first);
        } else {
            result = result && false;
        }

        if (last == s.last && last == null) {
            result = result && true;
        } else if (last != null) {
            result = result && last.equals(s.last);
        } else {
            result = result && false;
        }

        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<Solution>();
        //Solution s1 = new Solution("Donald", "Duck");
        Solution s1 = new Solution("Don", null);
        s.add(s1);

        Solution s2 = new Solution(null, "");
        System.out.println("s1 = " + s1.hashCode() + ", s2 = " + s2.hashCode());
        if (s1.equals(s2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        System.out.println(s.contains(s2));
    }
}
