package jp.co.stv_tech.test115

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fiveYearsTeacher = FiveYearsTeacher()
        fiveYearsTeacher.calculateSalary("山田花子",23,"女性",200000.0)

        val tenYearsTeacher = TenYearsTeacher()
        tenYearsTeacher.calculateSalary("佐藤二朗",50,"男性",400000.0)
    }
}
