package jp.co.stv_tech.test114

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val account1 = Account("山田花子", 23, "女性", "kotlin")
        val account2 = Account("佐藤二朗", 50, "男性", "swift")
        account1.result()
        account2.result()
    }
}
