package jp.co.stv_tech.test232

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.module.AppGlideModule
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.activity_main.*
//import kotlinx.android.synthetic.main.row.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {
    val weatherList: MutableList<MutableMap<String, String>> = mutableListOf()
    private val adapter = RecyclerListAdapter(weatherList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MainActivity", "onCreate")

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setLogo(R.mipmap.ic_launcher)
        setSupportActionBar(toolbar)
        val toolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.toolbarLayout)
        toolbarLayout.title = getString(R.string.toolbar_title)
        toolbarLayout.setExpandedTitleColor(Color.WHITE)
        toolbarLayout.setCollapsedTitleTextColor(Color.LTGRAY)

        val lvWeatherList = findViewById<RecyclerView>(R.id.lvWeatherList)

        val layout = LinearLayoutManager(applicationContext)
        lvWeatherList.layoutManager = layout

        lvWeatherList.adapter = adapter

        val decorator = DividerItemDecoration(applicationContext, layout.orientation)
        lvWeatherList.addItemDecoration(decorator)
    }
    public override fun onStart() {
        Log.i("MainActivity", "onStart")

        val receiver = WeatherInfoReceiver()
        receiver.execute("130010")

        super.onStart()
    }
    private fun createWeatherList():MutableList<MutableMap<String,String>> {
        Log.i("MainActivity", "createWeatherList")

        return weatherList
    }
    private inner class RecyclerListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var tvWeatherDesc:TextView = itemView.findViewById(R.id.tvWeatherDesc)
        var tvWeatherDate:TextView = itemView.findViewById(R.id.tvWeatherDate)
        var tvWeather:TextView = itemView.findViewById(R.id.tvWeather)
        var lvImage:ImageView = itemView.findViewById(R.id.lvImage)

    }
    private inner class RecyclerListAdapter(private val _listData: MutableList<MutableMap<String, String>>):
        RecyclerView.Adapter<RecyclerListViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerListViewHolder {
            Log.i("MainActivity", "onCreateViewHolder")

            val inflater = LayoutInflater.from(applicationContext)

            val view = inflater.inflate(R.layout.row, parent, false)

            return RecyclerListViewHolder(view)
        }
        override fun onBindViewHolder(holder: RecyclerListViewHolder, position: Int) {
            Log.i("MainActivity", "onBindViewHolder")

            val item = _listData[position]
            Log.i("MainActivity", "$position")
            val text = item["text"] as? String
            val date = item["date"] as? String
            val telop = item["telop"] as? String
            val url = item["url"] as? String

            holder.tvWeatherDesc.text = text
            holder.tvWeatherDate.text = date
            holder.tvWeather.text = telop

            Glide.with(this@MainActivity).load(url).into(holder.lvImage)
        }
        override fun getItemCount(): Int {
            Log.i("MainActivity", "getItemCount")

            return _listData.size
        }
    }
    @SuppressLint("StaticFieldLeak")
    private inner class WeatherInfoReceiver(): AsyncTask<String, String, String>() {
        override fun doInBackground(vararg params: String): String {
            Log.i("MainActivity", "doInBackground")

            val id = params[0]
            val urlStr = "http://weather.livedoor.com/forecast/webservice/json/v1?city=${id}"
            Log.i("MainActivity", "urlStr:$urlStr")

            val url = URL(urlStr)
            val con = url.openConnection() as HttpURLConnection
            con.requestMethod = "GET"
            con.connect()
            val stream = con.inputStream
            val result = is2String(stream)
            con.disconnect()
            stream.close()

            return result
        }

        override fun onPostExecute(result: String) {
            Log.i("MainActivity", "onPostExecute")
            val rootJSON = JSONObject(result)

            val forecasts = rootJSON.getJSONArray("forecasts")
            val description = rootJSON.getJSONObject("description")
            Log.i("MainActivity", "description:$description")
            val text = description.getString("text")
            Log.i("MainActivity", "text:$text")
            for (i in 0..1) {

                val forecastsNow = forecasts.getJSONObject(i)
                Log.i("MainActivity", "$i")
                val telop = forecastsNow.getString("telop")
                Log.i("MainActivity", "telop:$telop")

                val date = forecastsNow.getString("date")
                Log.i("MainActivity", "date:$date")

                val image = forecastsNow.getJSONObject("image")
                Log.i("MainActivity", "image:$image")
                val url = image.getString("url")
                Log.i("MainActivity", "url:$url")

                val weather = mutableMapOf("text" to text,"telop" to telop, "date" to date, "url" to url)
                weatherList.add(weather)
            }
            adapter.notifyDataSetChanged()

        }
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
}

