package jp.co.stv_tech.test116

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val designner = Designner()
        designner.computeYearlyPay()

        val programmer = Programmer()
        programmer.computeYearlyPay()
    }
}
