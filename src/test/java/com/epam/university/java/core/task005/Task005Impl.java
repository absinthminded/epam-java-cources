package com.epam.university.java.core.task005;


public class Task005Impl implements Task005 {
    @Override
    public PiHolder findPi(int digits) {
        if (digits <= 0 || digits >= 10) {
            throw new IllegalArgumentException();
        }

        PiHolder holder = new PiHolder();

        double valuesStart = Math.pow(10.0, digits - 1);
        double valuesEnd = Math.pow(10.0, digits);

        double maxValue = Integer.MAX_VALUE;

        for (double i = valuesStart; i < valuesEnd; i++) {
            for (double j = valuesStart; j <= i / 3; j++) {

                double abs = Math.abs((i / j) - Math.PI);
                if (abs < maxValue) {
                    maxValue = abs;
                    holder.setFirst((int)i);
                    holder.setSecond((int)j);
                }
            }
        }

        return  holder;
    }


}

    class PiHolder {
        private int first;
        private int second;

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }
