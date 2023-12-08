package com.sancho.geradordesorteiosloteriasdacaixa

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val btnVoltar: Button = findViewById(R.id.btn_voltar_quina)
        val numeros: EditText = findViewById(R.id.opc_numeros_quina)
        val btnSortear: Button = findViewById(R.id.btn_sortear_quina)
        val resultado: TextView = findViewById(R.id.resultado_quina)

        btnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnSortear.setOnClickListener {
            val qtdNumeros = numeros.text.toString()
            geradorDeNumeros(qtdNumeros, resultado)
        }

    }

    private fun geradorDeNumeros(text: String, resultado: TextView) {
        if (text.isEmpty()) {
            Toast.makeText(this,"Insira um número de 5 a 15", Toast.LENGTH_LONG).show()
            return
        }

        val qtd = text.toInt()

        if (qtd < 5 || qtd > 15) {
            Toast.makeText(this,"Insira um número de 5 a 15", Toast.LENGTH_LONG).show()
            return
        }

        val numerosSorteados = mutableSetOf<Int>()
        val random = Random()

        while (true) {
            val numero = random.nextInt(80)
            numerosSorteados.add(numero + 1)

            if (numerosSorteados.size == qtd) {
                break
            }
        }
        resultado.text = numerosSorteados.sorted().joinToString(" - ").toString()
    }
}