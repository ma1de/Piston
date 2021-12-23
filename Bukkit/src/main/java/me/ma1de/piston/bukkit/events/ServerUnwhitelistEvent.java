package me.ma1de.piston.bukkit.events;

import me.ma1de.piston.shared.server.PistonServer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ServerUnwhitelistEvent extends Event
{
    public static final HandlerList handlerList = new HandlerList();
    private boolean cancelled;
    public PistonServer server;

    public ServerUnwhitelistEvent(PistonServer server) {
        this.server = server;
        this.cancelled = false;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public PistonServer getServer() {
        return server;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
