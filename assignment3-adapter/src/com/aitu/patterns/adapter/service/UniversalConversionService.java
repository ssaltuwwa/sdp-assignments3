package com.aitu.patterns.adapter.service;

import com.aitu.patterns.adapter.api.Converter;
import com.aitu.patterns.adapter.api.ConversionRequest;
import com.aitu.patterns.adapter.api.Unit;

import java.util.List;

/** Service class that manages available converters and delegates requests. */
public class UniversalConversionService {
    private final List<Converter> converters;

    public UniversalConversionService(List<Converter> converters) {
        if (converters == null || converters.isEmpty()) {
            throw new IllegalArgumentException("At least one converter required");
        }
        this.converters = converters;
    }

    public double convert(double value, Unit from, Unit to) {
        var request = new ConversionRequest(value, from, to);
        for (Converter c : converters) {
            if (c.supports(from, to)) {
                return c.convert(request);
            }
        }
        throw new IllegalArgumentException("No adapter supports: " + from + " -> " + to);
    }
}
