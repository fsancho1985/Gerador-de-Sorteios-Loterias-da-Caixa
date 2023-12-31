package com.sancho.geradordesorteiosloteriasdacaixa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMegaDaVirada: Button = findViewById(R.id.btn_mega_da_virada)
        val btnMegaSena: Button = findViewById(R.id.btn_mega_sena)
        val btnQuina: Button = findViewById(R.id.btn_quina)

        btnMegaDaVirada.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        btnMegaSena.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        btnQuina.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }
    }
}