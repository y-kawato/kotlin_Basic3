package jp.co.stv_tech.test117

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result : Result = Math()
        result.calculate()
    }
    interface Result {

        fun calculate()
    }
}
