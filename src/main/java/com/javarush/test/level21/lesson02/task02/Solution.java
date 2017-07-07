package com.javarush.test.level21.lesson02.task02;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* Сравниваем модификаторы
Реализовать логику метода isAllModifiersContainSpecificModifier, который проверяет,
содержит ли переданный параметр allModifiers значение конкретного модификатора specificModifier
*/
public class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
        return (allModifiers & specificModifier) != 0;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}

/*
        boolean answer = false;

        switch (specificModifier) {
            case Modifier.ABSTRACT:
                answer = Modifier.isAbstract(allModifiers);
                break;

            case Modifier.FINAL:
                answer = Modifier.isFinal(allModifiers);
                break;

            case Modifier.INTERFACE:
                answer = Modifier.isInterface(allModifiers);
                break;

            case Modifier.NATIVE:
                answer = Modifier.isNative(allModifiers);
                break;

            case Modifier.PRIVATE:
                answer = Modifier.isPrivate(allModifiers);
                break;

            case Modifier.PROTECTED:
                answer = Modifier.isProtected(allModifiers);
                break;

            case Modifier.PUBLIC:
                answer = Modifier.isPublic(allModifiers);
                break;

            case Modifier.STATIC:
                answer = Modifier.isStatic(allModifiers);
                break;

            case Modifier.STRICT:
                answer = Modifier.isStrict(allModifiers);
                break;

            case Modifier.SYNCHRONIZED:
                answer = Modifier.isSynchronized(allModifiers);
                break;

            case Modifier.TRANSIENT:
                answer = Modifier.isTransient(allModifiers);
                break;

            case Modifier.VOLATILE:
                answer = Modifier.isVolatile(allModifiers);
                break;
        }
 */