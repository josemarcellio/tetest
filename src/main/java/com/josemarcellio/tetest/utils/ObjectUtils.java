package com.josemarcellio.tetest.utils;

import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectUtils {

    public static void createRandomObjects(int count) {
        Random random = new Random();
        List<Object> objects = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            objects.add(new byte[random.nextInt(1024 * 1024)]);
        }
        Bukkit.getLogger().info("objects size: " + objects.size());
    }
}
