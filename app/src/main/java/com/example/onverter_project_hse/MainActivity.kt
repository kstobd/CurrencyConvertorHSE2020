package com.example.onverter_project_hse

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.lang.NumberFormatException
import java.util.*

enum class Currency {
    NONE, RUB, USD, GBP, UAH, TND, EURO
}

class MainActivity : AppCompatActivity() {
   @RequiresApi(Build.VERSION_CODES.O)
   @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Locale.setDefault(Locale.US)
        setContentView(R.layout.activity_main)
        //val conver_but = findViewById<Button>(R.id.Conv_button)
        val USD_ET = findViewById<EditText>(R.id.USD_value_txt)
        val RUB_ET = findViewById<EditText>(R.id.RU_value_txt)
       val EURO_ET = findViewById<EditText>(R.id.EURO_value_txt)
       val GBP_ET = findViewById<EditText>(R.id.GBP_value_txt)
       val UAH_ET = findViewById<EditText>(R.id.UAH_value_txt)
       val TND_ET = findViewById<EditText>(R.id.TND_value_txt)
/*        conver_but.setOnClickListener {
            val RUB_value_str = RUB_ET.text.toString()
            if  (RUB_value_str == ""){
                val toast = Toast.makeText(this, "Enter value!", Toast.LENGTH_SHORT).apply {
                    show()
                }
                return@setOnClickListener
            }
            var convert_USD : Double = RUB_value_str.toDouble()
            convert_USD *= 69.87
            convert_USD.toString()
            USD_ET.setText("$convert_USD")
        }
        */
       var activeCurrency : Currency = Currency.NONE
       RUB_ET.setOnFocusChangeListener { _, hasFocus ->
           if (hasFocus) activeCurrency = Currency.RUB
       }
       RUB_ET.addTextChangedListener(object : TextWatcher {
           override fun onTextChanged(s: CharSequence, start: Int,
                                      before: Int, count: Int) {
               Log.d("TAG", s.toString())
           }

           override fun beforeTextChanged(s: CharSequence, start: Int,
                                          count: Int, after: Int) {
           }

           override fun afterTextChanged(s: Editable) {
               if (activeCurrency == Currency.RUB) {
                   val RUB_value_str = RUB_ET.text.toString()
                   try {
                       var convert_RUB : Double = RUB_value_str.toDouble()
                       var convert_USD_r = convert_RUB * 0.0146
                       USD_ET.setText(String.format("%.2f", convert_USD_r))
                       var convert_EURO_r = convert_RUB * 0.0128
                       EURO_ET.setText(String.format("%.2f", convert_EURO_r))
                       var convert_GBP_r = convert_RUB * 0.0114
                       GBP_ET.setText(String.format("%.2f", convert_GBP_r))
                       var convert_UAH_r = convert_RUB * 0.3882
                       UAH_ET.setText(String.format("%.2f", convert_UAH_r))
                       var convert_TND_r = convert_RUB * 0.04028
                       TND_ET.setText(String.format("%.2f", convert_TND_r))
                       Log.d("TAG", s.toString())
                   }
                   catch (e : NumberFormatException) {
                       val toast =
                           Toast.makeText(this@MainActivity, "Enter value!", Toast.LENGTH_SHORT)
                       toast.show()
                       USD_ET.setText("")
                       EURO_ET.setText("")
                       GBP_ET.setText("")
                       UAH_ET.setText("")
                       TND_ET.setText("")
                   }
               }
           }
       })
       USD_ET.setOnFocusChangeListener { _, hasFocus ->
           if (hasFocus) activeCurrency = Currency.USD
       }
       USD_ET.addTextChangedListener(object : TextWatcher {

           override fun onTextChanged(
               s: CharSequence, start: Int,
               before: Int, count: Int) {}

           override fun beforeTextChanged(
               s: CharSequence, start: Int,
               count: Int, after: Int
           ) {
           }

           override fun afterTextChanged(s: Editable) {
               if (activeCurrency == Currency.USD) {
                   val USD_value_str = USD_ET.text.toString()
                   try {
                       var convert_USD : Double = USD_value_str.toDouble()
                       var convert_RUB_us = convert_USD * 69.68868
                       RUB_ET.setText(String.format("%.2f", convert_RUB_us))
                       var convert_EURO_us = convert_USD * 0.8882
                       EURO_ET.setText(String.format("%.2f", convert_EURO_us))
                       var convert_GBP_us = convert_USD * 0.7972
                       GBP_ET.setText(String.format("%.2f", convert_GBP_us))
                       var convert_UAH_us = convert_USD * 26.4545
                       UAH_ET.setText(String.format("%.2f", convert_UAH_us))
                       var convert_TND_us = convert_USD * 2.8098
                       TND_ET.setText(String.format("%.2f", convert_TND_us))
                       Log.d("TAG", s.toString())
                   }
                   catch (e : NumberFormatException) {
                       val toast =
                           Toast.makeText(this@MainActivity, "Enter value!", Toast.LENGTH_SHORT)
                       toast.show()
                       RUB_ET.setText("")
                       EURO_ET.setText("")
                       GBP_ET.setText("")
                       UAH_ET.setText("")
                       TND_ET.setText("")
                   }
               }

           }
       })



       EURO_ET.setOnFocusChangeListener { _, hasFocus ->
           if (hasFocus) activeCurrency = Currency.EURO
       }
       EURO_ET.addTextChangedListener(object : TextWatcher {

           override fun onTextChanged(
               s: CharSequence, start: Int,
               before: Int, count: Int) {}

           override fun beforeTextChanged(
               s: CharSequence, start: Int,
               count: Int, after: Int
           ) {
           }

           override fun afterTextChanged(s: Editable) {
               if (activeCurrency == Currency.EURO) {
                   val EURO_value_str = EURO_ET.text.toString()
                   try {
                       var convert_EURO : Double = EURO_value_str.toDouble()
                       var convert_RUB_e = convert_EURO * 78.3886
                       RUB_ET.setText(String.format("%.2f", convert_RUB_e))
                       var convert_USD_e = convert_EURO * 1.1248
                       USD_ET.setText(String.format("%.2f", convert_USD_e))
                       var convert_GBP_e = convert_EURO * 0.8969
                       GBP_ET.setText(String.format("%.2f", convert_GBP_e))
                       var convert_UAH_e = convert_EURO * 29.7579
                       UAH_ET.setText(String.format("%.2f", convert_UAH_e))
                       var convert_TND_e = convert_EURO * 3.1606
                       TND_ET.setText(String.format("%.2f", convert_TND_e))
                       Log.d("TAG", s.toString())
                   }
                   catch (e : NumberFormatException) {
                       val toast =
                           Toast.makeText(this@MainActivity, "Enter value!", Toast.LENGTH_SHORT)
                       toast.show()
                       RUB_ET.setText("")
                       USD_ET.setText("")
                       GBP_ET.setText("")
                       UAH_ET.setText("")
                       TND_ET.setText("")
                   }
               }

           }
       })



       GBP_ET.setOnFocusChangeListener { _, hasFocus ->
           if (hasFocus) activeCurrency = Currency.GBP
       }
       GBP_ET.addTextChangedListener(object : TextWatcher {

           override fun onTextChanged(
               s: CharSequence, start: Int,
               before: Int, count: Int) {}

           override fun beforeTextChanged(
               s: CharSequence, start: Int,
               count: Int, after: Int
           ) {
           }

           override fun afterTextChanged(s: Editable) {
               if (activeCurrency == Currency.GBP) {
                   val GBP_value_str = GBP_ET.text.toString()
                   try {
                       var convert_GBP : Double = GBP_value_str.toDouble()
                       var convert_RUB_g = convert_GBP * 87.3217
                       RUB_ET.setText(String.format("%.2f", convert_RUB_g))
                       var convert_USD_g = convert_GBP * 1.253
                       USD_ET.setText(String.format("%.2f", convert_USD_g))
                       var convert_EURO_g = convert_GBP * 1.11323
                       EURO_ET.setText(String.format("%.2f", convert_EURO_g))
                       var convert_UAH_g = convert_GBP * 33.1491
                       UAH_ET.setText(String.format("%.2f", convert_UAH_g))
                       var convert_TND_g = convert_GBP * 3.508
                       TND_ET.setText(String.format("%.2f", convert_TND_g))
                       Log.d("TAG", s.toString())
                   }
                   catch (e : NumberFormatException) {
                       val toast =
                           Toast.makeText(this@MainActivity, "Enter value!", Toast.LENGTH_SHORT)
                       toast.show()
                       RUB_ET.setText("")
                       USD_ET.setText("")
                       EURO_ET.setText("")
                       UAH_ET.setText("")
                       TND_ET.setText("")
                   }
               }

           }
       })


       UAH_ET.setOnFocusChangeListener { _, hasFocus ->
           if (hasFocus) activeCurrency = Currency.UAH       }
       UAH_ET.addTextChangedListener(object : TextWatcher {

           override fun onTextChanged(
               s: CharSequence, start: Int,
               before: Int, count: Int) {}

           override fun beforeTextChanged(
               s: CharSequence, start: Int,
               count: Int, after: Int
           ) {
           }

           override fun afterTextChanged(s: Editable) {
               if (activeCurrency == Currency.UAH) {
                   val UAH_value_str = UAH_ET.text.toString()
                   try {
                       var convert_UAH : Double = UAH_value_str.toDouble()
                       var convert_RUB_ua = convert_UAH * 2.5844
                       RUB_ET.setText(String.format("%.2f", convert_RUB_ua))
                       var convert_USD_ua = convert_UAH * 0.03709
                       USD_ET.setText(String.format("%.2f", convert_USD_ua))
                       var convert_EURO_ua = convert_UAH * 0.0329
                       EURO_ET.setText(String.format("%.2f", convert_EURO_ua))
                       var convert_GBP_ua = convert_UAH * 0.0297
                       GBP_ET.setText(String.format("%.2f", convert_GBP_ua))
                       var convert_TND_ua = convert_UAH * 0.1042
                       TND_ET.setText(String.format("%.2f", convert_TND_ua))
                       Log.d("TAG", s.toString())
                   }
                   catch (e : NumberFormatException) {
                       val toast =
                           Toast.makeText(this@MainActivity, "Enter value!", Toast.LENGTH_SHORT)
                       toast.show()
                       RUB_ET.setText("")
                       USD_ET.setText("")
                       EURO_ET.setText("")
                       GBP_ET.setText("")
                       TND_ET.setText("")
                   }
               }

           }
       })

       TND_ET.setOnFocusChangeListener { _, hasFocus ->

           if (hasFocus) activeCurrency = Currency.TND       }
       TND_ET.addTextChangedListener(object : TextWatcher {

           override fun onTextChanged(
               s: CharSequence, start: Int,
               before: Int, count: Int) {}

           override fun beforeTextChanged(
               s: CharSequence, start: Int,
               count: Int, after: Int
           ) {
           }

           override fun afterTextChanged(s: Editable) {
               if (activeCurrency == Currency.TND) {
                   val TND_value_str = TND_ET.text.toString()
                   try {
                       var convert_TND : Double = TND_value_str.toDouble()
                       var convert_RUB_t = convert_TND * 24.2406
                       RUB_ET.setText(String.format("%.2f", convert_RUB_t))
                       var convert_USD_t = convert_TND * 0.34785
                       USD_ET.setText(String.format("%.2f", convert_USD_t))
                       var convert_EURO_t = convert_TND * 0.3089
                       EURO_ET.setText(String.format("%.2f", convert_EURO_t))
                       var convert_GBP_t = convert_TND * 0.2773
                       GBP_ET.setText(String.format("%.2f", convert_GBP_t))
                       var convert_UAH_t = convert_TND * 9.2022
                       UAH_ET.setText(String.format( "%.2f", convert_UAH_t))
                       Log.d("TAG", s.toString())
                   }
                   catch (e : NumberFormatException) {
                       val toast =
                           Toast.makeText(this@MainActivity, "Enter value!", Toast.LENGTH_SHORT)
                       toast.show()
                       RUB_ET.setText("")
                       USD_ET.setText("")
                       EURO_ET.setText("")
                       GBP_ET.setText("")
                       UAH_ET.setText("")
                   }
               }

           }
       })

    }
}

