package com.example.task21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var mainSelection: Spinner
    private lateinit var sourceSpinner: Spinner
    private lateinit var destinationSpinner: Spinner
    private lateinit var button: Button
    private lateinit var output: TextView
    private lateinit var input: EditText

    private var source = 0
    private var destination = 0
    private var conversionType = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainSelection = findViewById(R.id.spinner)
        sourceSpinner = findViewById(R.id.sourceType)
        destinationSpinner = findViewById(R.id.destinationType)
        button = findViewById(R.id.convert)
        output = findViewById(R.id.result)
        input = findViewById(R.id.units)

        mainSelection.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                conversionType = position
                changeSelection(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }


        sourceSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                source = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        destinationSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                destination = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }


        button.setOnClickListener {
            output.text = when(conversionType) {
                0 -> conversionLengthSource(source,destination,input.text.toString().toDouble())
                1 -> conversionWeightSource(source,destination,input.text.toString().toDouble())
                2 -> conversionTemperatureSource(source,destination,input.text.toString().toDouble())
                else -> conversionLengthSource(source,destination,input.text.toString().toDouble())
            }.toString()
        }
    }

    private fun changeSelection(type: Int) {
        val resource = when (type) {
            0 -> {
                resources.getStringArray(R.array.Length)
            }
            1 -> {
                resources.getStringArray(R.array.Weight)
            }
            2 -> {
                resources.getStringArray(R.array.Temperature)
            }
            else -> {
                resources.getStringArray(R.array.Length)
            }
        }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, resource
        )
        sourceSpinner.adapter = adapter

        destinationSpinner.adapter = adapter
    }

    fun conversionWeightSource(source: Int,destination: Int, input: Double): Double {
        return when(source) {
            0 -> conversionWeightDestinationForPound(destination,input)
            1 -> conversionWeightDestinationForOunce(destination,input)
            2 -> conversionWeightDestinationForTon(destination,input)
            else -> conversionWeightDestinationForPound(destination,input)
        }
    }

    fun conversionLengthSource(source: Int,destination: Int, input: Double): Double {
        return when(source) {
            0 -> conversionLengthDestinationForInches(destination,input)
            1 -> conversionLengthDestinationForFoot(destination,input)
            2 -> conversionLengthDestinationForYard(destination,input)
            3 -> conversionLengthDestinationForMiles(destination,input)
            else -> conversionLengthDestinationForInches(destination,input)
        }
    }

    fun conversionTemperatureSource(source: Int,destination: Int, input: Double): Double {
        return when(source) {
            0 -> conversionTemperatureDestinationForCelcius(destination,input)
            1 -> conversionTemperatureDestinationForFahrenheit(destination,input)
            2 -> conversionTemperatureDestinationForKelvin(destination,input)
            else -> conversionTemperatureDestinationForCelcius(destination,input)
        }
    }

    private fun conversionTemperatureDestinationForKelvin(destination: Int, input: Double): Double {
        return when(destination) {
            0 -> Utils.kelvinToCelsius(input)
            1 -> Utils.kelvinToFahrenheit(input)
            2 -> input
            else -> input
        }
    }

    private fun conversionTemperatureDestinationForFahrenheit(
        destination: Int,
        input: Double
    ): Double {
        return when(destination) {
            0 -> Utils.fahrenheitToCelsius(input)
            1 -> input
            2 -> Utils.fahrenheitToKelvin(input)
            else -> input
        }
    }

    private fun conversionTemperatureDestinationForCelcius(destination: Int, input: Double): Double {
        return when(destination) {
            0 -> input
            1 -> Utils.celsiusToFahrenheit(input)
            2 -> Utils.celsiusToKelvin(input)
            else -> input
        }
    }

    private fun conversionWeightDestinationForOunce(destination: Int, input: Double): Double {
        return when(destination) {
            0 -> Utils.ouncesToPounds(input)
            1 -> input
            2 -> Utils.ouncesToTons(input)
            else -> input
        }
    }

    private fun conversionWeightDestinationForTon(destination: Int, input: Double): Double {
        return when(destination) {
            0 -> Utils.tonsToPounds(input)
            1 -> Utils.tonsToOunces(input)
            2 -> input
            else -> input
        }
    }

    private fun conversionWeightDestinationForPound(destination: Int, input: Double): Double {
        return when(destination) {
            0 -> input
            1 -> Utils.poundsToOunces(input)
            2 -> Utils.poundsToTons(input)
            else -> input
        }
    }


    private fun conversionLengthDestinationForMiles(destination: Int, input: Double): Double {
        return when(destination) {
            0 -> Utils.milesToInches(input)
            1 -> Utils.milesToFeet(input)
            2 -> Utils.milesToYards(input)
            3 -> input
            else -> input
        }
    }

    private fun conversionLengthDestinationForYard(destination: Int, input: Double): Double {
        return when(destination) {
            0 -> Utils.yardsToInches(input)
            1 -> Utils.yardsToFeet(input)
            2 -> input
            3 -> Utils.yardsToMiles(input)
            else -> input
        }
    }

    private fun conversionLengthDestinationForFoot(destination: Int, input: Double): Double {
        return when(destination) {
            0 -> Utils.feetToInches(input)
            1 -> input
            2 -> Utils.feetToYards(input)
            3 -> Utils.feetToMiles(input)
            else -> input
        }
    }

    private fun conversionLengthDestinationForInches(destination: Int, input: Double): Double {
        return when(destination) {
            0 -> input
            1 -> Utils.inchesToFeet(input)
            2 -> Utils.inchesToYards(input)
            3 -> Utils.inchesToMiles(input)
            else -> input
        }
    }

}