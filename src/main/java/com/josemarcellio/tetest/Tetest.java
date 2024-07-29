package com.josemarcellio.tetest;

import com.josemarcellio.tetest.calculations.ExtremeCalculator;
import com.josemarcellio.tetest.calculations.IntensiveCalculator;
import com.josemarcellio.tetest.calculations.MandelbrotCalculator;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tetest extends JavaPlugin {
    private ExecutorService executor;

    @Override
    public void onEnable() {

        getLogger().info("Tetest enabled!");

        executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.submit(new MandelbrotCalculator());
            executor.submit(new IntensiveCalculator());
            executor.submit(new ExtremeCalculator());
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Tetest disabled!");
        executor.shutdown();
    }
}
