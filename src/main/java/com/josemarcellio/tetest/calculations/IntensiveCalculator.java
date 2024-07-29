package com.josemarcellio.tetest.calculations;

import com.josemarcellio.tetest.utils.CalculationUtils;
import org.bukkit.Bukkit;

public class IntensiveCalculator implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    Bukkit.getLogger().warning("CalculationUtils interrupted!");
                    return;
                }
                CalculationUtils.complexCalculations();
            }
        } catch (Exception e) {
            Bukkit.getLogger().severe(e.getMessage());
        }
    }
}
