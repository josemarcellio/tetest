package com.josemarcellio.tetest;

public class IntensiveCalculator implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                complexCalculations();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void complexCalculations() {
        final int size = 1000;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double result = Math.sin(i * j) * Math.cos(i + j);
                result = Math.log(Math.abs(result) + 1);
            }
        }
    }
}
