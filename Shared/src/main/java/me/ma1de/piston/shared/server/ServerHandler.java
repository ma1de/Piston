package me.ma1de.piston.shared.server;

import com.mongodb.client.model.Filters;
import me.ma1de.piston.bukkit.events.ServerShutdownEvent;
import me.ma1de.piston.bukkit.events.ServerStartupEvent;
import me.ma1de.piston.bukkit.events.ServerUnwhitelistEvent;
import me.ma1de.piston.bukkit.events.ServerWhitelistEvent;
import me.ma1de.piston.shared.PistonShared;
import org.bukkit.Bukkit;

import java.util.List;
import java.util.UUID;

public class ServerHandler
{
    public PistonServer getServer(String value) {
        for (PistonServer server : PistonShared.servers) {
            if (server.getId().equals(value)) {
                return server;
            }

            if (server.getName().equals(value)) {
                return server;
            }
        }
        return null;
    }

    public void unWhitelist(PistonServer server) {
        server.setStatus(ServerStatus.ONLINE);
        Bukkit.getPluginManager().callEvent(new ServerUnwhitelistEvent(server));
    }

    public void whitelist(PistonServer server) {
        server.setStatus(ServerStatus.WHITELISTED);
        Bukkit.getPluginManager().callEvent(new ServerWhitelistEvent(server));
    }

    public void shutdown(PistonServer server) {
        server.setStatus(ServerStatus.OFFLINE);
        Bukkit.getPluginManager().callEvent(new ServerShutdownEvent(server));
    }

    public void startup(PistonServer server){
        server.setStatus(ServerStatus.ONLINE);
        Bukkit.getPluginManager().callEvent(new ServerStartupEvent(server));
    }

    public void createServer(ServerStatus status, String name, double tps, int online, int maximumOnline, List<UUID> players) {
        PistonServer server = new PistonServer(status, name, tps, online, maximumOnline, players);

        if (PistonShared.servers.contains(server) && PistonShared.getDatabase().getCollection("servers").find(Filters.eq("name", name)).first() != null) {
            try {
                throw new Exception("Tried to create a server by name " + name + " but it already exists in the array list and mongo database");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return;
        }

        PistonShared.servers.add(server);
        PistonShared.getDatabase().getCollection("servers").insertOne(server.toBson());
    }
}
