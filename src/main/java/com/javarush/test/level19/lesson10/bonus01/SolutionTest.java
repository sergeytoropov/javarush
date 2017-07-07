package com.javarush.test.level19.lesson10.bonus01;

/*
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class SolutionTest
{
    //private Solution solution = new Solution();

    @Test
    public void testAlgorithm1() throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("строка1");
        list.add("строка2");
        list.add("строка1");

        ArrayList<String> listUpdated = new ArrayList<String>();
        listUpdated.add("строка2");
        listUpdated.add("строка3");
        listUpdated.add("строка1");
        listUpdated.add("строка4");

        List<Solution.LineItem> items = new ArrayList<Solution.LineItem>();
        items.add(new Solution.LineItem(Solution.Type.REMOVED, "строка1"));
        items.add(new Solution.LineItem(Solution.Type.SAME, "строка2"));
        items.add(new Solution.LineItem(Solution.Type.ADDED, "строка3"));
        items.add(new Solution.LineItem(Solution.Type.SAME, "строка1"));
        items.add(new Solution.LineItem(Solution.Type.ADDED, "строка4"));

        Solution.algorithm(list, listUpdated);

        for (int i = 0; i < items.size(); i++) {
            Assert.assertEquals(items.get(i).type, Solution.lines.get(i).type, "Тип");
            Assert.assertEquals(items.get(i).line, Solution.lines.get(i).line, "Значение");
        }

        Solution.lines.clear();
    }

    @Test
    public void testAlgorithm2() throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("строка1");
        list.add("строка4");
        list.add("строка5");

        ArrayList<String> listUpdated = new ArrayList<String>();
        listUpdated.add("строка2");
        listUpdated.add("строка1");
        listUpdated.add("строка3");
        listUpdated.add("строка4");
        listUpdated.add("строка5");
        listUpdated.add("строка6");

        List<Solution.LineItem> items = new ArrayList<Solution.LineItem>();
        items.add(new Solution.LineItem(Solution.Type.ADDED, "строка2"));
        items.add(new Solution.LineItem(Solution.Type.SAME, "строка1"));
        items.add(new Solution.LineItem(Solution.Type.ADDED, "строка3"));
        items.add(new Solution.LineItem(Solution.Type.SAME, "строка4"));
        items.add(new Solution.LineItem(Solution.Type.SAME, "строка5"));
        items.add(new Solution.LineItem(Solution.Type.ADDED, "строка6"));


        Solution.algorithm(list, listUpdated);

        for (int i = 0; i < items.size(); i++) {
            Assert.assertEquals(items.get(i).type, Solution.lines.get(i).type, "Тип");
            Assert.assertEquals(items.get(i).line, Solution.lines.get(i).line, "Значение");
        }

        Solution.lines.clear();
    }

}
*/