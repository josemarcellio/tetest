package com.josemarcellio.tetest;

public class MandelbrotCalculator implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                mandelbrotSet();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mandelbrotSet() {
        final int width = 800;
        final int height = 800;
        final int maxIterations = 1000;
        double zoom = 1.0;
        double moveX = 0.0;
        double moveY = 0.0;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
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
            }
        }
    }
}
