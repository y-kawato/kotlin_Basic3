package jp.co.stv_tech.test213

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.floor


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MainActivity", "onCreate")

        val btClick = findViewById<Button>(R.id.btClick)
        val listener = HelloListener()
        btClick.setOnClickListener(listener)

        val iv1 = findViewById<ImageView>(R.id.iv1)

    }
    private inner class HelloListener : View.OnClickListener {


        override fun onClick(v: View?) {
            val i = Log.i("MainActivity", "onClick")

            val gazouArray = resources.obtainTypedArray(R.array.gazou)

            val rand = floor(Math.random() * 5).toInt()

            val drawable: Drawable? = gazouArray.getDrawable(rand);

            iv1.setImageDrawable(drawable)

            gazouArray.recycle()
        }

    }
}
