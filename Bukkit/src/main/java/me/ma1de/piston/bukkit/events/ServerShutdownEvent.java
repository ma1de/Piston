package me.ma1de.piston.bukkit.events;

import me.ma1de.piston.shared.server.PistonServer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ServerShutdownEvent extends Event
{
    private static final HandlerList handlerList = new HandlerList();
    private boolean cancelled;
    public PistonServer server;

    public ServerShutdownEvent(PistonServer server) {
        this.server = server;
        this.cancelled = false;
    }

    public PistonServer getServer() {
        return server;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
