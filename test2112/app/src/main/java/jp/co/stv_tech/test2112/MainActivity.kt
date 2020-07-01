package jp.co.stv_tech.test2112

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

            private lateinit var gAdapter: GazouAdapter
            private lateinit var gGazouList: ArrayList<Gazou>

            override fun onCreate(savedInstanceState: Bundle?) {
                Log.i("GazouAdapter", "onCreate")
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                val map = Gazou("地図",  R.drawable.map_2)
                val money = Gazou("お金",  R.drawable.money_2)
                val noimage = Gazou("ノーイメージ",  R.drawable.noimage_2)
                val refresh = Gazou("リフレッシュ",  R.drawable.refresh_2)
                val time = Gazou("時間",  R.drawable.time_2)
                val train = Gazou("電車",  R.drawable.train_2)
                val img1 = Gazou("画像1",R.drawable.img_1)
                val map3 = Gazou("画像3",R.drawable.map_3)
                gGazouList = arrayListOf(map, money, noimage, refresh, time, train, img1, map3)

                val lvGazou = findViewById<RecyclerView>(R.id.lvGazou)

                val layoutManager = GridLayoutManager(this,2)
                lvGazou.layoutManager = layoutManager

                gAdapter = GazouAdapter(gGazouList)
                lvGazou.adapter = gAdapter
    }

    private inner class GazouAdapter(private val gazouList: ArrayList<Gazou>): RecyclerView.Adapter<GazouAdapter.ViewHolder>() {
            inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            val lvGazouView: ImageView = view.findViewById(R.id.lvGazouView)
            val tvGazouName: TextView = view.findViewById(R.id.tvGazouName)
        }
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.row, viewGroup, false)
            Log.i("GazouAdapter", "onCreateViewHolder")

            view.setOnClickListener(ImageClickListener())
            return ViewHolder(view)
        }
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            Log.i("GazouAdapter", "onBindViewHolder")
            val gazou = gazouList[position]

            viewHolder.lvGazouView.setImageResource(gazou.imageId)
            viewHolder.tvGazouName.text = gazou.name
        }
        override fun getItemCount() = gazouList.size
    }
    private inner class ImageClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            Log.i("GazouAdapter", "onClick")
            val tvGazouName = view.findViewById<TextView>(R.id.tvGazouName)
            val gazouName = tvGazouName.text.toString()
            Toast.makeText(applicationContext, gazouName, Toast.LENGTH_SHORT).show()
        }
    }
}
