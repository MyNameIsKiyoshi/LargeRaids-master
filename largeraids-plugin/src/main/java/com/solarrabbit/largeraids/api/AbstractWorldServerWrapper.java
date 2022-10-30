package com.solarrabbit.largeraids.api;

public interface AbstractWorldServerWrapper {
    AbstractRaidWrapper getRaidAt(AbstractBlockPositionWrapper blockPos);

    AbstractRaidsWrapper getRaids();

    AbstractVillageManagerWrapper getVillageRecordManager();
}
