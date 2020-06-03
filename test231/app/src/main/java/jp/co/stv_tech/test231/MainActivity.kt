package jp.co.stv_tech.test231

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MainActivity", "onCreate")

        val receiver = WeatherInfoReceiver(this)
        receiver.execute("130010")
    }

    private fun is2String(stream: InputStream): String {
        Log.i("MainActivity", "is2String")
        val sb = StringBuilder()
        val reader = BufferedReader(InputStreamReader(stream, "UTF-8"))
        var line = reader.readLine()
        while (line != null) {
            sb.append(line)
            line = reader.readLine()
        }
        reader.close()
        return sb.toString()
    }

    companion object {
        private class WeatherInfoReceiver(private val mainActivity: MainActivity): AsyncTask<String, String, String>() {
            override fun doInBackground(vararg params: String?): String {
                Log.i("MainActivity", "doInBackground")

                val id = params[0]
                val urlStr = "http://weather.livedoor.com/forecast/webservice/json/v1?city=${id}"

                val url = URL(urlStr)
                val con = url.openConnection() as HttpURLConnection
                con.requestMethod = "GET"
                con.connect()
                val stream = con.inputStream
                val result = mainActivity.is2String(stream)
                con.disconnect()
                stream.close()

                return result
            }

            override fun onPostExecute(result: String) {
                Log.i("MainActivity", "onPostExecute")
                val rootJSON = JSONObject(result)

                val forecasts = rootJSON.getJSONArray("forecasts")

                for (i in 0..1) {
                    val forecastsNow = forecasts.getJSONObject(i)
                    Log.i("MainActivity", "$i")
                    val telop = forecastsNow.getString("telop")
                    Log.i("MainActivity", "telop:$telop")

                    val dialogFragment = TestDialogFragment()
                    val args = Bundle()
                    args.putString("telop", telop)
                    dialogFragment.arguments = args
                    dialogFragment.show(mainActivity.supportFragmentManager, "TestDialogFragment")
                }
            }
        }
    }
}
