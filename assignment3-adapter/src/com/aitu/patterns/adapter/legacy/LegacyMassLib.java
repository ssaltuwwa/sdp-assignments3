package com.aitu.patterns.adapter.legacy;

/** Legacy library with non-standard conversion methods for mass. */
public class LegacyMassLib {
    private static final double LB_TO_KG = 0.45359237;

    public double poundsToKg(double pounds) { return pounds * LB_TO_KG; }
    public double kgToPounds(double kg) { return kg / LB_TO_KG; }
}
