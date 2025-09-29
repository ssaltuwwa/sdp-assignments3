package com.aitu.patterns.adapter.api;

import java.util.EnumSet;

/** Supported units grouped by categories. */
public enum Unit {
    KILOMETER(UnitCategory.LENGTH),
    MILE(UnitCategory.LENGTH),
    METER(UnitCategory.LENGTH),
    FOOT(UnitCategory.LENGTH),

    KILOGRAM(UnitCategory.MASS),
    POUND(UnitCategory.MASS),

    CELSIUS(UnitCategory.TEMPERATURE),
    FAHRENHEIT(UnitCategory.TEMPERATURE);

    private final UnitCategory category;

    Unit(UnitCategory category) {
        this.category = category;
    }

    public UnitCategory category() {
        return category;
    }

    public static final EnumSet<Unit> LENGTH_UNITS =
            EnumSet.of(KILOMETER, MILE, METER, FOOT);

    public static final EnumSet<Unit> MASS_UNITS =
            EnumSet.of(KILOGRAM, POUND);

    public static final EnumSet<Unit> TEMP_UNITS =
            EnumSet.of(CELSIUS, FAHRENHEIT);
}
