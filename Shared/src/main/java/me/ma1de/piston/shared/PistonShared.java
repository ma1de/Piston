package me.ma1de.piston.shared;

import com.google.common.collect.Lists;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import me.ma1de.piston.shared.server.PistonServer;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class PistonShared
{
    public static Random RANDOM = new Random();
    public static List<PistonServer> servers = Lists.newArrayList();
    private static MongoClient client = new MongoClient("localhost");
    private static MongoDatabase database = client.getDatabase("PistonX");

    public PistonShared() {
        if (database.getCollection("servers") == null)
            database.createCollection("servers");
    }

    public static MongoClient getClient() {
        return client;
    }

    public static MongoDatabase getDatabase() {
        return database;
    }
}
