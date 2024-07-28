package com.josemarcellio.tetest;

import org.bukkit.plugin.java.JavaPlugin;

public class Tetest extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Tetest enabled!");
        
        for (int i = 0; i < 5; i++) {
            new Thread(new MandelbrotCalculator()).start();
            new Thread(new IntensiveCalculator()).start();
            new Thread(new ExtremeCalculator()).start();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Tetest disabled!");
    }
}
