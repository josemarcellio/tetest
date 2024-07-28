package com.josemarcellio.tetest;

import java.util.ArrayList;
import java.util.List;

public class ExtremeCalculator implements Runnable {
    private final List<double[][]> memoryLeaks = new ArrayList<>();

    @Override
    public void run() {
        try {
            while (true) {
                performExtremeCalculations();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void performExtremeCalculations() {

        final int iterations = 2000;
        double[][] matrix = new double[iterations][iterations];

        for (int i = 0; i < iterations; i++) {
            for (int j = 0; j < iterations; j++) {
                matrix[i][j] = Math.sin(i * j) * Math.cos(i + j);
                matrix[i][j] = Math.sqrt(Math.abs(matrix[i][j]));
            }
        }

        double totalSum = 0;
        for (int i = 0; i < iterations; i++) {
            for (int j = 0; j < iterations; j++) {
                totalSum += matrix[i][j];
            }
        }

        memoryLeaks.add(matrix);
    }
}
