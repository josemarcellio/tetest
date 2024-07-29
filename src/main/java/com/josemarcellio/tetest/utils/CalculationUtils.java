package com.josemarcellio.tetest.utils;

import java.util.stream.IntStream;
import org.bukkit.Bukkit;

public class CalculationUtils {

    public static void complexCalculations() {
        final int size = 2000;

        IntStream.range(0, size).parallel().forEach(i -> IntStream.range(0, size).parallel().forEach(j -> {
            double result = Math.sin(i * j) * Math.cos(i + j);
            result = Math.log(Math.abs(result) + 1);
            result = Math.tan(result) * Math.cbrt(result);

            Bukkit.getLogger().info("Complex calculation result: " + result);
        }));
    }

    public static void mandelbrotSet() {
        final int width = 1600;
        final int height = 1600;
        final int maxIterations = 2000;
        double zoom = 1.0;
        double moveX = 0.0;
        double moveY = 0.0;

        IntStream.range(0, width).parallel().forEach(x -> IntStream.range(0, height).parallel().forEach(y -> {
            double c_re = (x - width / 2.0) * 4.0 / width * zoom + moveX;
            double c_im = (y - height / 2.0) * 4.0 / height * zoom + moveY;
            double x_re = c_re, x_im = c_im;
            int n;

            for (n = 0; n < maxIterations; n++) {
                double x_re2 = x_re * x_re, x_im2 = x_im * x_im;
                if (x_re2 + x_im2 > 4) break;
                x_im = 2 * x_re * x_im + c_im;
                x_re = x_re2 - x_im2 + c_re;
            }
        }));
    }
}
