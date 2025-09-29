# Assignment 3 – Adapter Pattern (Metric ↔ Imperial Unit Conversion)

## 📌 Task Description
According to the syllabus, Assignment #3 requires the implementation of the **Adapter Pattern**.  
The specific task:  
> Implement an Adapter for unit conversion (Metric ↔ Imperial) or data parser (XML ↔ JSON).  
> Submit code + UML + short report.  
> Demonstrate application of principles from *Clean Code*.  
> Defense during Week 4 practice class.

This project implements a **unit conversion system** (length, mass, temperature) using **Adapter Pattern** in Java.

---

## 🏗️ Pattern Explanation
The **Adapter Pattern** is a *structural design pattern* that allows objects with incompatible interfaces to work together.

- **Target (expected interface):** `Converter`  
- **Adaptee (existing incompatible class):** `LegacyDistanceLib`, `LegacyMassLib`, `LegacyTemperatureLib`  
- **Adapter (bridge between them):** `DistanceAdapter`, `MassAdapter`, `TemperatureAdapter`  
- **Client (uses only the Target interface):** `App` via `UniversalConversionService`  

---

## ✅ Clean Code Principles Applied
1. **Meaningful Names** – class and method names clearly describe their purpose.  
2. **Single Responsibility Principle** – each adapter is responsible for one category (length, mass, temperature).  
3. **Open/Closed Principle** – new units can be added by creating a new adapter without modifying existing code.  
4. **Dependency Injection** – legacy libraries are passed into adapters via constructors.  
5. **Small Functions** – each method does one thing (convert to meters, convert from meters, etc.).  
6. **Readable Structure** – project separated into `api/`, `adapters/`, `legacy/`, `service/`.  

---

'''mermaid
classDiagram
    direction LR
    class UnitCategory
    class Unit {
      +category(): UnitCategory
      <<enum>>
    }
    class ConversionRequest {
      +value: double
      +from: Unit
      +to: Unit
    }
    class Converter {
      <<interface>>
      +supports(from: Unit, to: Unit) boolean
      +convert(req: ConversionRequest) double
    }

    class LegacyDistanceLib {
      +miToKm(mi: double) double
      +kmToMi(km: double) double
      +feetToMeters(ft: double) double
      +metersToFeet(m: double) double
    }
    class LegacyMassLib {
      +poundsToKg(lb: double) double
      +kgToPounds(kg: double) double
    }
    class LegacyTemperatureLib {
      +celsiusToFahrenheit(c: double) double
      +fahrenheitToCelsius(f: double) double
    }

    class DistanceAdapter {
      -legacy: LegacyDistanceLib
      +supports(from,to) boolean
      +convert(req) double
    }
    class MassAdapter {
      -legacy: LegacyMassLib
      +supports(from,to) boolean
      +convert(req) double
    }
    class TemperatureAdapter {
      -legacy: LegacyTemperatureLib
      +supports(from,to) boolean
      +convert(req) double
    }

    class UniversalConversionService {
      -converters: List<Converter>
      +convert(value: double, from: Unit, to: Unit) double
    }

    class App

    Converter <|.. DistanceAdapter
    Converter <|.. MassAdapter
    Converter <|.. TemperatureAdapter

    DistanceAdapter --> LegacyDistanceLib
    MassAdapter --> LegacyMassLib
    TemperatureAdapter --> LegacyTemperatureLib

    UniversalConversionService o--> Converter
    App --> UniversalConversionService
