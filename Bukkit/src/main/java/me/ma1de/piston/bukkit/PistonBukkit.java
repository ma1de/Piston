package me.ma1de.piston.bukkit;

import org.bukkit.plugin.java.JavaPlugin;

public class PistonBukkit extends JavaPlugin
{
    private static PistonBukkit instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static PistonBukkit getInstance() {
        return instance;
    }
}
