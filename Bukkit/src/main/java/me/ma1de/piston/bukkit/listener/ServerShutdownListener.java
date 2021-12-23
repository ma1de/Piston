package me.ma1de.piston.bukkit.listener;

import me.ma1de.piston.bukkit.events.ServerShutdownEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;

public class ServerShutdownListener implements Listener
{
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onShutdown(PluginDisableEvent event) {

    }
}
