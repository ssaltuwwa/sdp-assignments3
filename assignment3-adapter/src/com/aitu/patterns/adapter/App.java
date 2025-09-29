package com.aitu.patterns.adapter;

import com.aitu.patterns.adapter.adapters.*;
import com.aitu.patterns.adapter.api.Unit;
import com.aitu.patterns.adapter.legacy.*;
import com.aitu.patterns.adapter.service.UniversalConversionService;

import java.util.List;

import static com.aitu.patterns.adapter.api.Unit.*;

/** Demo application for the Adapter pattern with unit conversions. */
public class App {
    public static void main(String[] args) {
        var service = new UniversalConversionService(List.of(
                new DistanceAdapter(new LegacyDistanceLib()),
                new MassAdapter(new LegacyMassLib()),
                new TemperatureAdapter(new LegacyTemperatureLib())
        ));

        System.out.println("10 miles = " + service.convert(10, MILE, KILOMETER) + " km");
        System.out.println("5 km = " + service.convert(5, KILOMETER, MILE) + " miles");
        System.out.println("80 kg = " + service.convert(80, KILOGRAM, POUND) + " lb");
        System.out.println("20 °C = " + service.convert(20, CELSIUS, FAHRENHEIT) + " °F");
    }
}
