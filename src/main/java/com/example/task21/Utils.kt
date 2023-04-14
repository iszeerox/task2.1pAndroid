package com.example.task21

object Utils {
    //Weight
    fun poundsToOunces(pounds: Double): Double {
        return pounds * 16.0
    }

    fun poundsToGrams(pounds: Double): Double {
        return pounds * 453.592
    }

    fun poundsToKilograms(pounds: Double): Double {
        return pounds * 0.453592
    }

    fun ouncesToPounds(ounces: Double): Double {
        return ounces / 16.0
    }

    fun ouncesToGrams(ounces: Double): Double {
        return ounces * 28.35
    }

    fun ouncesToKilograms(ounces: Double): Double {
        return ounces * 0.02835
    }

    fun gramsToPounds(grams: Double): Double {
        return grams / 453.592
    }

    fun gramsToOunces(grams: Double): Double {
        return grams / 28.35
    }

    fun gramsToTons(grams: Double): Double {
        return grams / 1000000.0
    }

    fun gramsToKilograms(grams: Double): Double {
        return grams / 1000.0
    }

    fun kilogramsToPounds(kilograms: Double): Double {
        return kilograms / 0.453592
    }

    fun kilogramsToOunces(kilograms: Double): Double {
        return kilograms / 0.02835
    }

    fun kilogramsToGrams(kilograms: Double): Double {
        return kilograms * 1000.0
    }

    fun tonsToPounds(tons: Double): Double {
        return tons * 2000.0
    }

    fun tonsToOunces(tons: Double): Double {
        return tons * 32000.0
    }

    fun tonsToGrams(tons: Double): Double {
        return tons * 1e+6
    }

    fun tonsToKilograms(tons: Double): Double {
        return tons * 1000.0
    }

    fun poundsToTons(pounds: Double): Double {
        return pounds / 2000.0
    }

    fun ouncesToTons(ounces: Double): Double {
        return ounces / 32000.0
    }
    //Weight

    //Length
    fun inchesToFeet(inches: Double): Double {
        return inches / 12.0
    }

    fun feetToInches(feet: Double): Double {
        return feet * 12.0
    }

    fun feetToYards(feet: Double): Double {
        return feet / 3.0
    }

    fun yardsToFeet(yards: Double): Double {
        return yards * 3.0
    }

    fun feetToMiles(feet: Double): Double {
        return feet / 5280.0
    }

    fun milesToFeet(miles: Double): Double {
        return miles * 5280.0
    }


    fun yardsToMiles(yards: Double): Double {
        return yards / 1760.0
    }

    fun milesToYards(miles: Double): Double {
        return miles * 1760.0
    }

    fun inchesToCentimeters(inches: Double): Double {
        return inches * 2.54
    }

    fun centimetersToInches(centimeters: Double): Double {
        return centimeters / 2.54
    }

    fun kilometersToMiles(kilometers: Double): Double {
        return kilometers / 1.609344
    }

    fun milesToKilometers(miles: Double): Double {
        return miles * 1.609344
    }

    fun inchesToYards(inches: Double): Double {
        return inches / 36.0
    }

    fun yardsToInches(yards: Double): Double {
        return yards * 36.0
    }

    fun inchesToMiles(inches: Double): Double {
        return inches / 63360.0
    }

    fun milesToInches(miles: Double): Double {
        return miles * 63360.0
    }



    fun inchToKm(inches: Double): Double {
        return milesToKilometers(yardsToMiles(feetToYards(inchesToFeet(inches))))
    }
    //Length

    //Temperature
    fun celsiusToFahrenheit(celsius: Double): Double {
        return celsius * 9.0 / 5.0 + 32.0
    }

    fun fahrenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32.0) * 5.0 / 9.0
    }

    fun celsiusToKelvin(celsius: Double): Double {
        return celsius + 273.15
    }

    fun kelvinToCelsius(kelvin: Double): Double {
        return kelvin - 273.15
    }

    fun fahrenheitToKelvin(fahrenheit: Double): Double {
        return (fahrenheit + 459.67) * 5.0 / 9.0
    }

    fun kelvinToFahrenheit(kelvin: Double): Double {
        return kelvin * 9.0 / 5.0 - 459.67
    }
    //Temperature
}