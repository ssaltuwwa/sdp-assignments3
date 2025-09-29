package com.aitu.patterns.adapter.legacy;

/** Legacy library with non-standard conversion methods for length. */
public class LegacyDistanceLib {
    private static final double MI_TO_KM = 1.60934;
    private static final double FT_TO_M  = 0.3048;

    public double miToKm(double mi) { return mi * MI_TO_KM; }
    public double kmToMi(double km) { return km / MI_TO_KM; }
    public double feetToMeters(double ft) { return ft * FT_TO_M; }
    public double metersToFeet(double m) { return m / FT_TO_M; }
}
