@file:Suppress("DEPRECATION")

package jp.co.stv_tech.kotlin2114

import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.row.view.*

class testAdapter(fm:FragmentManager, private val context: Context): FragmentPagerAdapter(fm) {

    fun getIcon(position: Int){
        Log.i("testAdapter", "getIcon")
        when (position) {
            0 -> {
                R.drawable.gazou_1
            }
            1 -> {
                R.drawable.gazou_2
            }
            else -> R.drawable.gazou_3
        }
    }


    override fun getItem(position: Int): Fragment {
        Log.i("testAdapter", "getItem")
        when (position) {
            0 -> {
                return test1Fragment()
            }
            1 -> {
                return test2Fragment()
            }
            else -> {
                return test3Fragment()
            }

        }
    }

    override fun getCount(): Int {
        Log.i("testAdapter", "getCount")
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        Log.i("testAdapter", "getPageTitle")
        when (position) {
            0 -> {
                return "test1"
            }
            1 -> {
                return "test2"
            }
            else -> {
                return "test3"
            }
        }
    }
}


