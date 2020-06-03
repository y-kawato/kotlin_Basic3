package jp.co.stv_tech.kotlin2114

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager.adapter = testAdapter(supportFragmentManager,this)
        tab_layout.setupWithViewPager(pager)

        tab_layout.getTabAt(0)?.setIcon(R.drawable.gazou_1);
        tab_layout.getTabAt(1)?.setIcon(R.drawable.gazou_2);
        tab_layout.getTabAt(2)?.setIcon(R.drawable.gazou_3);

    }
}
