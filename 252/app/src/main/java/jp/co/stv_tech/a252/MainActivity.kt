package jp.co.stv_tech.a252

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = intent
        val action = intent.action

        if (Intent.ACTION_VIEW == action) {
            val uri = intent.data

            if (uri != null) {
                val caption: String = uri.getQueryParameter("caption").toString()
                val comment: String = uri.getQueryParameter("comment").toString()
                val txtView1 = findViewById<TextView>(R.id.txtView1)
                val txtView2 = findViewById<TextView>(R.id.txtView2)
                txtView1.text = caption
                txtView2.text = comment
            }
        }
    }
}