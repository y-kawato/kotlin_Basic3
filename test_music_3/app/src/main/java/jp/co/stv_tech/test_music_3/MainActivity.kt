package jp.co.stv_tech.test_music_3

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: CustomAdapter
    lateinit var mMusicList: ArrayList<Music>
    lateinit var mp0: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val m = Music("m",R.drawable.play_2,R.drawable.stop_2,R.raw.music_1)
        val u = Music("u",R.drawable.play_2,R.drawable.stop_2,R.raw.music_2)
        val s = Music("s",R.drawable.play_2,R.drawable.stop_2,R.raw.music_3)
        val i = Music("i",R.drawable.play_2,R.drawable.stop_2,R.raw.music_4)
        val c = Music("c",R.drawable.play_2,R.drawable.stop_2,R.raw.music_5)

        mMusicList = arrayListOf(m, u, s, i, c)

        // RecyclerViewの取得
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        // LayoutManagerの設定
        recyclerView.layoutManager = LinearLayoutManager(this)

        // CustomAdapterの生成と設定
        mAdapter = CustomAdapter(mMusicList)
        recyclerView.adapter = mAdapter
    }
    private inner class CustomAdapter(private val musicList: ArrayList<Music>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

        // Viewの初期化
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val playId: ImageButton = view.findViewById(R.id.playId)
            val stopId: ImageButton = view.findViewById(R.id.stopId)
            val title: TextView = view.findViewById(R.id.title)

        }

        // レイアウトの設定
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)

            view.setOnClickListener(ImageClickListener())
            return ViewHolder(view)
        }

        // Viewの設定
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            val music = musicList[position]

            viewHolder.playId.setImageResource(music.playId)
            viewHolder.stopId.setImageResource(music.stopId)
            viewHolder.title.text = music.title

        }

        // 表示数を返す
        override fun getItemCount() = musicList.size
    }

        private inner class ImageClickListener : View.OnClickListener {
            override fun onClick(view: View) {

                val title = view.findViewById<TextView>(R.id.title)
                val titleName = title.text.toString()
                Toast.makeText(applicationContext, titleName, Toast.LENGTH_SHORT).show()
            }
        }


}