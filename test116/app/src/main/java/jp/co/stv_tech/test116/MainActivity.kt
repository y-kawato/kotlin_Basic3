package jp.co.stv_tech.test116

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val designner = Designner()
        designner.computeYearlyPay("佐藤二朗",50,"男性","東京",400000,10)

        val programmer = Programmer()
        programmer.computeYearlyPay("山田花子",23,"女性","東京",200000,5)
    }
}
