package com.sancho.geradordesorteiosloteriasdacaixa

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val numeros: EditText = findViewById(R.id.opc_numeros)
        val btnSortear: Button = findViewById(R.id.btn_sortear)
        val resultado: TextView = findViewById(R.id.resultado)
        val btnVoltar: Button = findViewById(R.id.btn_voltar)

        btnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnSortear.setOnClickListener {
            val qtdNumeros = numeros.text.toString()
            geradorDeNumerosSorteados(qtdNumeros, resultado)
        }
    }

    private fun geradorDeNumerosSorteados(text: String, result: TextView) {
        if (text.isEmpty()) {
            Toast.makeText(this, "Insira um número de 6 a 15", Toast.LENGTH_LONG).show()
            return
        }
        println(text)
        val qtd = text.toInt()

        if (qtd < 6 || qtd > 15) {
            Toast.makeText(this, "Insira um número de 6 a 15", Toast.LENGTH_LONG).show()
            return
        }

        val numerosSorteados = mutableSetOf<Int>()
        val random = Random()

        while (true) {
            val numero = random.nextInt(60)
            numerosSorteados.add(numero + 1)

            if (numerosSorteados.size == qtd) {
                break
            }
        }

        result.text = numerosSorteados.sorted().joinToString(" - ").toString()

    }

}