package com.aitu.patterns.adapter.api;

/** Immutable request object containing value and unit conversion pair. */
public final class ConversionRequest {
    private final double value;
    private final Unit from;
    private final Unit to;

    public ConversionRequest(double value, Unit from, Unit to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Units must not be null");
        }
        if (from.category() != to.category()) {
            throw new IllegalArgumentException(
                    "Incompatible categories: " + from + " -> " + to);
        }
        this.value = value;
        this.from = from;
        this.to = to;
    }

    public double value() { return value; }
    public Unit from()    { return from; }
    public Unit to()      { return to; }
}
