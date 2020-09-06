package com.example.kotlinapp01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculaJuros(component:View) {

        val nome = et_nome.text
        val valor = et_valor.text.toString().toDouble()
        val parcelas = et_parcelas.text.toString().toInt()

        if (nome.length < 3) {
            tv_frase.text = "Por favor preencha o campo 'nome' corretamente"
            tv_frase.setTextColor(Color.parseColor("#696969"))
            tv_frase.visibility = View.VISIBLE
        } else if (valor <=0) {
            tv_frase.text = "Favor informar um valor válido"
            tv_frase.setTextColor(Color.parseColor("#696969"))
            tv_frase.visibility = View.VISIBLE
        } else if (parcelas > 12) {
            tv_frase.text = "É possível parcelar em até 12x"
            tv_frase.setTextColor(Color.parseColor("#696969"))
            tv_frase.visibility = View.VISIBLE
        } else if (parcelas <= 0) {
            tv_frase.text = "Favor informar a quantidade de parcelas"
            tv_frase.setTextColor(Color.parseColor("#696969"))
            tv_frase.visibility = View.VISIBLE
        } else{
            val calc = ((valor/100 * 0.6) * parcelas)
            if (calc < 30.0) {
                tv_frase.visibility = View.VISIBLE
                tv_frase.setTextColor(Color.parseColor("#000080"))
                tv_frase.text = "$nome, para esta compra não serão cobrados juros" +
                        " o valor total será de $valor"

            } else{
                tv_frase.visibility = View.VISIBLE
                tv_frase.setTextColor(Color.parseColor("#800000"))
                tv_frase.text = "$nome, o juros aplicado será de" +
                        " R$${"%.2f".format(calc/parcelas)} x$parcelas" +
                        " e o valor total será de R$${"%.2f".format(valor+calc)}"

            }
        }

    }

}