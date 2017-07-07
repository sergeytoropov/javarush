package com.javarush.test.level18.lesson10.home08.test;

/*
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;
import org.junit.rules.TemporaryFolder;

public class SolutionTest {

    public TemporaryFolder tmpFld = new TemporaryFolder();

    public ExternalResource rule = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            super.before();

            System.out.println(tmpFld.toString());
            System.out.println(tmpFld.getRoot());
        }

        @Override
        protected void after() {
            super.after();
        }
    };

    @Rule
    public RuleChain rules = RuleChain.outerRule(tmpFld).around(rule);

    @Test
    public void test() {
        System.out.println("My Test");
    }
}
*/