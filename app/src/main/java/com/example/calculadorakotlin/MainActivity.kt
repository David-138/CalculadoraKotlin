package com.example.calculadorakotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.calculadorakotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val num1 = binding.num1
        val num2 = binding.num2
        val sumar = binding.sumar
        val resultado = binding.resultado

        sumar.setOnClickListener {
            val num1Str = num1.text.toString()
            val num2Str = num2.text.toString()

            if (num1Str.isNotEmpty() && num2Str.isNotEmpty()) {
                try {
                    val num1Value = num1Str.toDouble()
                    val num2Value = num2Str.toDouble()
                    val suma = num1Value + num2Value

                    if (suma % 1 == 0.0) {
                        resultado.text = getString(R.string.resultado, suma.toInt().toString())
                    } else {
                        resultado.text = getString(R.string.resultado, suma.toString())
                    }
                } catch (e: NumberFormatException) {
                    resultado.text = getString(R.string.resultado_error)
                }
            } else {
                resultado.text = getString(R.string.resultado_error)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}