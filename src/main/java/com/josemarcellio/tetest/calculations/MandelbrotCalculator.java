package com.josemarcellio.tetest.calculations;

import com.josemarcellio.tetest.utils.CalculationUtils;
import org.bukkit.Bukkit;

public class MandelbrotCalculator implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    Bukkit.getLogger().warning("MandelbrotCalculator interrupted!");
                    return;
                }
                CalculationUtils.mandelbrotSet();
            }
        } catch (Exception e) {
            Bukkit.getLogger().severe(e.getMessage());
        }
    }
}
