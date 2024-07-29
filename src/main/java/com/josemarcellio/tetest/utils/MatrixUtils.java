package com.josemarcellio.tetest.utils;

import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MatrixUtils {
    private static final List<double[][]> memoryLeaks = new ArrayList<>();

    public static void performExtremeCalculations() {
        final int iterations = 4000;
        double[][] matrix = new double[iterations][iterations];

        IntStream.range(0, iterations).parallel().forEach(i -> IntStream.range(0, iterations).parallel().forEach(j -> {
            double value = Math.sin(i * j) * Math.cos(i + j);
            value = Math.sqrt(Math.abs(value));
            value = Math.exp(value);
            matrix[i][j] = value;
        }));

        double totalSum = IntStream.range(0, iterations).parallel()
                .mapToDouble(i -> IntStream.range(0, iterations).parallel()
                        .mapToDouble(j -> matrix[i][j]).sum()).sum();

        memoryLeaks.add(matrix);

        Bukkit.getLogger().info("memoryLeaks size: " + memoryLeaks.size());
        Bukkit.getLogger().info("totalSum: " + totalSum);

        ObjectUtils.createRandomObjects(iterations);
    }
}
