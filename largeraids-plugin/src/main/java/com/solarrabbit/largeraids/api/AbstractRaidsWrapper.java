package com.solarrabbit.largeraids.api;

public interface AbstractRaidsWrapper {
    AbstractRaidWrapper createOrExtendRaid(AbstractPlayerEntityWrapper player);

    void setDirty();
}
