package jp.co.stv_tech.test246

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        video_view.setVideoPath("http://techslides.com/demos/sample-videos/small.mp4")
        val mediaController = MediaController(this)
        mediaController.requestFocus()
        video_view.setOnPreparedListener(MediaPlayer.OnPreparedListener { mediaController.show(0) })
        mediaController.setAnchorView(video_view)
        video_view.setMediaController(mediaController)
        video_view.start()
    }
}