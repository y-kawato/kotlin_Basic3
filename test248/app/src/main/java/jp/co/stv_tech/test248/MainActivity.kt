package jp.co.stv_tech.test248

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.app.LoaderManager
import androidx.loader.content.Loader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<Bitmap> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            Log.v("nullpo", "1a")

            progressbar.visibility = android.widget.ProgressBar.VISIBLE

            val args: Bundle = Bundle().also {
                it.putString("url", "https://s.yimg.jp/images/top/sp2/cmn/logo-170307.png")
            }
            LoaderManager.getInstance(this).initLoader(1, args, this)
        }

        button2.setOnClickListener {
            Log.v("nullpo", "1b")

            progressbar.visibility = android.widget.ProgressBar.VISIBLE

            val args: Bundle = Bundle().also {
                it.putString("url", "https://upload.wikimedia.org/wikipedia/commons/9/9a/PNG_transparency_demonstration_2.png")
            }
            LoaderManager.getInstance(this).initLoader(2, args, this)
        }
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Bitmap> {
        Log.v("nullpo", "CreateLoader")
        val getImage: GetImage = GetImage(this, args?.getString("url") ?: "")

        getImage.onContentChanged()
        return getImage
    }
    override fun onLoadFinished(loader: Loader<Bitmap>, data: Bitmap?) {
        Log.v("nullpo", "LoadFinished")
        if (data != null) {
            progressbar.visibility = android.widget.ProgressBar.INVISIBLE
        }

        if (data != null) {
            imageView.setImageBitmap(data)
        }
    }
    override fun onLoaderReset(loader: Loader<Bitmap>) {
    }
}