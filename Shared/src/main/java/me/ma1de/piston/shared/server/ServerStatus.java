package me.ma1de.piston.shared.server;

import org.bukkit.ChatColor;

import java.util.Objects;

public enum ServerStatus
{
    ONLINE("Online", ChatColor.GREEN),
    OFFLINE("Offline", ChatColor.RED),
    WHITELISTED("Whitelisted", ChatColor.YELLOW),
    UNKNOWN("Unknown", ChatColor.DARK_RED);

    private String normal;
    private ChatColor color;

    ServerStatus(String normal, ChatColor color) {
        this.normal = normal;
        this.color = color;
    }

    public String getNormal() {
        if (Objects.equals(normal, "Unknown")) {
            try {
                throw new IllegalArgumentException("ServerStatus cannot be UNKNOWN");
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }
        return this.normal;
    }

    public ChatColor getColor() {
        return this.color;
    }
}
