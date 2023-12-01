package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        val classificacao = if (result < 18.5f){
            "Você está a baixo do peso, considerado magreza."
        } else if (result in 18.5..24.9) {
             "Você está em seu peso ideal, parabéns! "
        } else if (result in 25.0..29.9){
             "Você está em sobrepeso."
        }else if(result in 30.0..39.99){
              "Você está em grau de obesidade nivel 1."
        }else  {
              "Você está em grau de obesidade nivel 2 grave."
        }

        tvClassificacao.text = getString(R.string.massage_classificação,classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }


}