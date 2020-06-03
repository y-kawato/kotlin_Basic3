package jp.co.stv_tech.test115

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val teacher = Teacher("山田花子",23,"女性",200000.0)
        teacher.result()

        val fiveYearsTeacher = FiveYearsTeacher()
        fiveYearsTeacher.result()

        val tenYearsTeacher = TenYearsTeacher()
        tenYearsTeacher.result()
    }

}
