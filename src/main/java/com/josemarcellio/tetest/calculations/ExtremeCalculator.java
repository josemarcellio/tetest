package com.josemarcellio.tetest.calculations;

import com.josemarcellio.tetest.utils.MatrixUtils;
import org.bukkit.Bukkit;

public class ExtremeCalculator implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    Bukkit.getLogger().warning("ExtremeCalculator interrupted!");
                    return;
                }
                MatrixUtils.performExtremeCalculations();
            }
        } catch (Exception e) {
            Bukkit.getLogger().severe(e.getMessage());
        }
    }
}
