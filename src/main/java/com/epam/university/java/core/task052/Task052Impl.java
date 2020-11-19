package com.epam.university.java.core.task052;

public class Task052Impl implements Task052 {
    @Override
    public boolean validateCard(long number) {
        if (String.valueOf(number).startsWith("-")
            || String.valueOf(number).length() < 10) {
            throw new IllegalArgumentException();
        }

        if (String.valueOf(number).replaceAll("0", "").length() == 2) {
            return true;
        }

        return (getSize(number) >= 13 && getSize(number) <= 16) && (prefixMatch(number, 1)
                || prefixMatch(number, 5) || prefixMatch(number, 37) || prefixMatch(number, 6))
                && ((sumDoubleEven(number) + sumOdd(number)) % 10 == 0);
    }

    /**
     * sum .
     * @param number to calculate.
     * @return sum.
     */
    public static int sumDoubleEven(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i >= 0; i -= 2) {
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        }
        return sum;
    }

    /**
     * get Digit.
     * @param number to get digit.
     * @return digit.
     */
    public static int getDigit(int number) {
        if (number < 9) {
            return number;
        }
        return number / 10 + number % 10;
    }

    /**
     * sum of odd.
     * @param number to calculate.
     * @return sum.
     */
    public static int sumOdd(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 1; i >= 0; i -= 2) {
            sum += Integer.parseInt(num.charAt(i) + "");
        }
        return sum;
    }

    public static boolean prefixMatch(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    public static int getSize(long d) {
        String num = d + "";
        return num.length();
    }

    /**
     * function to get prefix.
     * @param number number.
     * @param k number.
     * @return prefix.
     */
    public static long getPrefix(long number, int k) {
        if (getSize(number) > k) {
            String num = number + "";
            return Long.parseLong(num.substring(0, k));
        }
        return number;
    }
}
