package com.aitu.patterns.adapter.adapters;

import com.aitu.patterns.adapter.api.*;
import com.aitu.patterns.adapter.legacy.LegacyMassLib;

import static com.aitu.patterns.adapter.api.Unit.*;

/** Adapter for mass conversions using LegacyMassLib. */
public class MassAdapter implements Converter {
    private final LegacyMassLib legacy;

    public MassAdapter(LegacyMassLib legacy) {
        this.legacy = legacy;
    }

    @Override
    public boolean supports(Unit from, Unit to) {
        return Unit.MASS_UNITS.contains(from) && Unit.MASS_UNITS.contains(to);
    }

    @Override
    public double convert(ConversionRequest request) {
        double v = request.value();
        Unit from = request.from();
        Unit to = request.to();

        if (from == to) return v;
        if (from == KILOGRAM && to == POUND) return legacy.kgToPounds(v);
        if (from == POUND && to == KILOGRAM) return legacy.poundsToKg(v);

        throw new IllegalArgumentException("Unsupported mass conversion: " + from + " -> " + to);
    }
}
