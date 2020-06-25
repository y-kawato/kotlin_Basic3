package jp.co.stv_tech.test245

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekR.max = 255
        seekG.max = 255
        seekB.max = 255
        var renkR: Int = seekR.progress
        var renkG: Int = seekG.progress
        var renkB: Int = seekB.progress

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setColorFilter(Color.rgb(renkR, renkG, renkB))

        seekR.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, proggres: Int, p2: Boolean) {
                renkR = proggres
                imageView.setColorFilter(Color.rgb(renkR, renkG, renkB))
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        seekG.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, proggres: Int, p2: Boolean) {
                renkG = proggres
                imageView.setColorFilter(Color.rgb(renkR, renkG, renkB))

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        seekB.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, proggres: Int, p2: Boolean) {
                renkB = proggres
                imageView.setColorFilter(Color.rgb(renkR, renkG, renkB))

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
    }
}