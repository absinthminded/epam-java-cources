package com.epam.university.java.core.task028;


import com.fasterxml.jackson.databind.node.POJONode;

public class Task028Impl implements Task028 {
    @Override
    public int getWays(int value, int power) {
        return count(value, power, 1);
    }

    /**
     * Auxiliary function for recursive count.
     * @param value value.
     * @param power power.
     * @param num number.
     * @return count.
     */
    public static int count(int value, int power, int num) {
        if (Math.pow(num, power) < value) {
            return count(value, power, ++num)
                   + count((int)(value - Math.pow(num, power)), power, ++num);
        } else if (Math.pow(num, power) == value) {
            return 1;
        } else {
            return 0;
        }
    }
}
