package com.solarrabbit.largeraids.util;

import com.mojang.authlib.GameProfile;
import com.solarrabbit.largeraids.api.AbstractBlockPositionWrapper;
import com.solarrabbit.largeraids.api.AbstractCraftRaidWrapper;
import com.solarrabbit.largeraids.api.AbstractCraftRaiderWrapper;
import com.solarrabbit.largeraids.api.AbstractCraftServerWrapper;
import com.solarrabbit.largeraids.api.AbstractCraftVexWrapper;
import com.solarrabbit.largeraids.api.AbstractCraftWorldWrapper;
import com.solarrabbit.largeraids.api.AbstractMinecraftServerWrapper;
import com.solarrabbit.largeraids.api.AbstractPlayerEntityWrapper;
import com.solarrabbit.largeraids.api.AbstractPoiTypeWrapper;
import com.solarrabbit.largeraids.api.AbstractRaidWrapper;
import com.solarrabbit.largeraids.api.AbstractWorldServerWrapper;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Raid;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Raider;
import org.bukkit.entity.Vex;

public class VersionUtil {
    private static final String[] VERSIONS = new String[] { "v1_14_R1", "v1_15_R1", "v1_16_R3", "v1_17_R1",
            "v1_18_R1", "v1_18_R2" };

    public static AbstractBlockPositionWrapper getBlockPositionWrapper(Location location) {
        return getBlockPositionWrapper(location.getX(), location.getY(), location.getZ());
    }

    public static AbstractBlockPositionWrapper getBlockPositionWrapper(double x, double y, double z) {
        return null;
    }

    public static AbstractCraftRaidWrapper getCraftRaidWrapper(AbstractRaidWrapper wrapper) {
        return null;
    }

    public static AbstractCraftRaidWrapper getCraftRaidWrapper(Raid raid) {
        return null;
    }

    public static AbstractCraftRaiderWrapper getCraftRaiderWrapper(Raider raider) {
        return null;
    }

    public static AbstractCraftServerWrapper getCraftServerWrapper(Server server) {
        return null;
    }

    public static AbstractCraftWorldWrapper getCraftWorldWrapper(World world) {
        return null;
    }

    public static AbstractPlayerEntityWrapper getPlayerEntityWrapper(AbstractMinecraftServerWrapper server,
            AbstractWorldServerWrapper world,
            GameProfile profile) {
        return null;
    }

    public static AbstractPoiTypeWrapper getMasonPoiTypeWrapper() {
        return null;
    }

    public static AbstractCraftVexWrapper getCraftVexWrapper(Vex vex) {
        return null;
    }

    public static int getServerMinorVersion() {
        return getMinorVersion(getServerVersion());
    }

    public static boolean isSupported() {
        String apiVersion = getAPIVersion();
        for (String version : VERSIONS)
            if (version.equals(apiVersion))
                return true;
        return false;
    }

    public static int compare(String versionA, String versionB) {
        int majDiff = getMajorVersion(versionA) - getMajorVersion(versionB);
        if (majDiff != 0)
            return majDiff;
        int minorDiff = getMinorVersion(versionA) - getMinorVersion(versionB);
        if (minorDiff != 0)
            return minorDiff;
        return getPatchVersion(versionA) - getPatchVersion(versionB);
    }

    private static int getMajorVersion(String version) {
        String[] splits = version.split("\\.");
        return Integer.parseInt(splits[0]);
    }

    private static int getMinorVersion(String version) {
        String[] splits = version.split("\\.");
        return splits.length < 2 ? 0 : Integer.parseInt(splits[1]);
    }

    private static int getPatchVersion(String version) {
        String[] splits = version.split("\\.");
        return splits.length < 3 ? 0 : Integer.parseInt(splits[2]);
    }

    private static String getServerVersion() {
        return getCraftServerWrapper(Bukkit.getServer()).getServer().getServerVersion();
    }

    private static String getAPIVersion() {
        return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    }

}
