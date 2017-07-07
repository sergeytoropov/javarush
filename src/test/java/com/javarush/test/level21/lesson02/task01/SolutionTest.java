package com.javarush.test.level21.lesson02.task01;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;

    byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
    byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};

    @Test
    public void getNetAddress() {
        byte[] address = {(byte) 0xC0, (byte) 0xA8, (byte) 0x00, (byte) 0x00};

        solution = new Solution();
        assertArrayEquals(solution.getNetAddress(ip, mask), address);
    }

    @Test
    public void print() {
        solution = new Solution();
        solution.print(solution.getNetAddress(ip, mask));
    }
}