package com.jaques.projetos.calculadoradegorjetaprojetokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.String.format

private var editValor: EditText? = null
private var textPorcentangem: TextView? = null
private var textGorjeta: TextView? = null
private var textTotal: TextView? = null
private var seekBarGorjeta: SeekBar? = null
private var porcentagem: Double = 0.0


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editValor = idValor
        textPorcentangem = idTextPorcentagem
        textGorjeta = idTextGorjeta
        textTotal = idTextTotal
        seekBarGorjeta = idSeekBar

        // Adcionar listener para o seekBar

        seekBarGorjeta?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, b: Boolean) {
                // Display the current progress of SeekBar
                porcentagem = progress.toDouble()
                textPorcentangem?.text = "${Math.round(porcentagem)}%"
                calcular()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something

            }
        })

    }

    fun calcular(): Unit {

        val valorRecuperado: String = editValor?.text.toString()
        if (valorRecuperado == null || valorRecuperado.equals("")) {
            Toast.makeText(
                applicationContext,
                "Digite um valor primeiro!",
                Toast.LENGTH_LONG
            ).show()
        } else{
            //converte string para double
            val valorDigitado: Double = valorRecuperado.toDouble()

            //calula gorjeta
            val gorjeta: Double = valorDigitado * (porcentagem/100)
            val total: Double = gorjeta + valorDigitado

            //Exibir a gorjeta
            textGorjeta?.text = "R$ ${Math.round(gorjeta)}"
            textTotal?.text =  "R$ ${total}"


        }

    }
}
