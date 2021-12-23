package me.ma1de.piston.shared.server;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

import org.bson.Document;

public class PistonServer
{
    private ServerStatus status;
    private String id = UUID.randomUUID().toString().substring(0, 6);
    private String name;
    private double tps;
    private int online;
    private int maximumOnline;
    private List<UUID> players;

    public PistonServer(ServerStatus status, String name, double tps, int online, int maximumOnline, List<UUID> players) {
        this.status = status;
        this.name = name;
        this.tps = tps;
        this.online = online;
        this.maximumOnline = maximumOnline;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServerStatus getStatus() {
        return status;
    }

    public void setStatus(ServerStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }


    public double getTps() {
        return tps;
    }

    public int getOnline() {
        return online;
    }

    public int getMaximumOnline() {
        return maximumOnline;
    }

    public void setMaximumOnline(int maximumOnline) {
        this.maximumOnline = maximumOnline;
    }

    public List<UUID> getPlayers() {
        return players;
    }

    public Document toBson() {
        return new Document("_id", id)
                .append("status", status.getNormal())
                .append("name", name)
                .append("tps", tps)
                .append("online", online)
                .append("maxOnline", maximumOnline)
                .append("players", players);
    }
}
