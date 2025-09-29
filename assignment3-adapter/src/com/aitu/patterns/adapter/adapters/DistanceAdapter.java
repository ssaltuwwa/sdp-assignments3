package com.aitu.patterns.adapter.adapters;

import com.aitu.patterns.adapter.api.ConversionRequest;
import com.aitu.patterns.adapter.api.Converter;
import com.aitu.patterns.adapter.api.Unit;
import com.aitu.patterns.adapter.api.UnitCategory;
import com.aitu.patterns.adapter.legacy.LegacyDistanceLib;

/** Adapter for distance conversions using LegacyDistanceLib. */
public class DistanceAdapter implements Converter {
    private final LegacyDistanceLib legacy;

    public DistanceAdapter(LegacyDistanceLib legacy) {
        this.legacy = legacy;
    }

    @Override
    public boolean supports(Unit from, Unit to) {
        return from.category() == UnitCategory.LENGTH && to.category() == UnitCategory.LENGTH;
    }

    @Override
    public double convert(ConversionRequest request) {
        double meters = toMeters(request.from(), request.value());
        return fromMeters(request.to(), meters);
    }

    private double toMeters(Unit from, double value) {
        return switch (from) {
            case METER     -> value;
            case FOOT      -> legacy.feetToMeters(value);
            case KILOMETER -> value * 1000.0;
            case MILE      -> legacy.miToKm(value) * 1000.0;
            default        -> throw new IllegalArgumentException("Unsupported length unit: " + from);
        };
    }

    private double fromMeters(Unit to, double meters) {
        return switch (to) {
            case METER     -> meters;
            case FOOT      -> legacy.metersToFeet(meters);
            case KILOMETER -> meters / 1000.0;
            case MILE      -> legacy.kmToMi(meters / 1000.0);
            default        -> throw new IllegalArgumentException("Unsupported length unit: " + to);
        };
    }
}
