package com.solarrabbit.largeraids.api;

import java.util.function.Predicate;

public interface AbstractPoiTypeWrapper {
    Predicate<? super AbstractPoiTypeWrapper> getPredicate();
}
