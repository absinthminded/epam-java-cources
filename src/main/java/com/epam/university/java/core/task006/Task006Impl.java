package com.epam.university.java.core.task006;

import java.util.Collection;

public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {

        if (measurements == null) {
            throw new IllegalArgumentException();
        }

        int numOfM = measurements.size();
        double sumA = 0.0;
        double sumV = 0.0;


        for (Measurement m : measurements) {
            sumA = sumA + m.getAmperage();
            sumV = sumV + m.getVoltage();
        }

        double avgA = sumA / numOfM;
        double avgV = sumV / numOfM;

        double power = 0.0;
        double squareAmperage = 0.0;

        for (Measurement m : measurements) {
            power = power + ((m.getVoltage() - avgV) * (m.getAmperage() - avgA));
            squareAmperage = squareAmperage + (Math.pow(m.getAmperage() - avgA, 2));
        }

        int resistance = (int) ((power / squareAmperage) * 1000);

        return resistance / 1000.0;
    }
}