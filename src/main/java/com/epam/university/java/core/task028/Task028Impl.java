package com.epam.university.java.core.task028;



public class Task028Impl implements Task028 {
    @Override
    public int getWays(int value, int power) {

        return count(value, power, 1);
    }

    /**
     * Auxiliary function for recursive count.
     * @param x value.
     * @param n power.
     * @param num number.
     * @return count.
     */
    public static int count(int x,int n,int num) {
        if (Math.pow(num, n) < x) {
            return count(x, n, num + 1) + count((int)(x - Math.pow(num, n)), n, num + 1);
        } else if (Math.pow(num, n) == x) {
            return 1;
        } else {
            return 0;
        }
    }

}
