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

## ⚙️ How to Run
1. Install JDK 17+ (tested on JDK 25).  
2. Clone the repo:  
   ```bash
   git clone https://github.com/your-username/assignment3-adapter.git
   cd assignment3-adapter
