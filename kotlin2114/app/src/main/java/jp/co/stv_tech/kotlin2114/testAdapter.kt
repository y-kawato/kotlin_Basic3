@file:Suppress("DEPRECATION")

package jp.co.stv_tech.kotlin2114

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TestAdapter(fm:FragmentManager, private val context: Context): FragmentPagerAdapter(fm) {

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
                return Test1Fragment()
            }
            1 -> {
                return Test2Fragment()
            }
            else -> {
                return Test3Fragment()
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


