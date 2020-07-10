package jp.co.stv_tech.test248

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class GetImage(context: Context, var url: String) : GetImageBase<Bitmap>(context) {
    private lateinit var urlConnection: HttpURLConnection

    override fun loadInBackground(): Bitmap? {
        Log.v("nullpo", "loadInBackGround")

        val url: URL = URL(url)

        try {

            urlConnection = (url.openConnection() as HttpURLConnection).also {
                it.requestMethod = "GET"
                it.connectTimeout = 1000
                it.readTimeout = 10000
                it.connect()
            }
            return when (urlConnection.responseCode) {
                HttpsURLConnection.HTTP_OK -> {
                    BitmapFactory.decodeStream(urlConnection.inputStream)
                }
                else -> {
                    null
                }
            }
        } catch (e: Exception) {
            return null
        } finally {
            urlConnection.disconnect()
        }
    }
}