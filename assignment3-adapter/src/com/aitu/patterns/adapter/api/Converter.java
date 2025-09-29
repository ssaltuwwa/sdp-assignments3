package com.aitu.patterns.adapter.api;

/** Target interface expected by clients. */
public interface Converter {
    boolean supports(Unit from, Unit to);
    double convert(ConversionRequest request);
}
