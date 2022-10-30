package com.solarrabbit.largeraids.api;


import com.solarrabbit.largeraids.raid.mob.Raider;

public abstract class AbstractCraftRaiderWrapper {
    protected final Raider raider;

    public AbstractCraftRaiderWrapper(Raider raider) {
        this.raider = raider;
    }

    public abstract AbstractRaiderWrapper getHandle();
}
