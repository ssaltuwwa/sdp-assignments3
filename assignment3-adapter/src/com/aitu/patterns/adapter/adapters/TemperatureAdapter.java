package com.aitu.patterns.adapter.adapters;

import com.aitu.patterns.adapter.api.*;
import com.aitu.patterns.adapter.legacy.LegacyTemperatureLib;

import static com.aitu.patterns.adapter.api.Unit.*;

/** Adapter for temperature conversions using LegacyTemperatureLib. */
public class TemperatureAdapter implements Converter {
    private final LegacyTemperatureLib legacy;

    public TemperatureAdapter(LegacyTemperatureLib legacy) {
        this.legacy = legacy;
    }

    @Override
    public boolean supports(Unit from, Unit to) {
        return Unit.TEMP_UNITS.contains(from) && Unit.TEMP_UNITS.contains(to);
    }

    @Override
    public double convert(ConversionRequest request) {
        double v = request.value();
        Unit from = request.from();
        Unit to = request.to();

        if (from == to) return v;
        if (from == CELSIUS && to == FAHRENHEIT) return legacy.celsiusToFahrenheit(v);
        if (from == FAHRENHEIT && to == CELSIUS) return legacy.fahrenheitToCelsius(v);

        throw new IllegalArgumentException("Unsupported temperature conversion: " + from + " -> " + to);
    }
}
