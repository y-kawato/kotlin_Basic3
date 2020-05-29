package jp.co.stv_tech.test113

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val man = 3
        if (man < 10){
            println("Hello if")
        }

        val item = 11
        if (item < 10){
            println("Hello if")
        }
        else{
            println("Hello else")
        }

        val count = 15
        when {
            count < 10 -> {
                println("Hello if")
            }
            count == 15 -> {
                println("Hello else if")
            }
            else -> {
                println("Hello else")
            }
        }

        val number = 15
        val msg = if (number < 10) "Hello if" else "Hello else"
        println(msg)

        var i = 0
        while (i < 10) {
            println(i++)
        }

        var t = 0
        do {
            println(t++)
        } while(t < 10)

        for (p in 1..15) {
            println(p)
        }

        val list = listOf("AA", "BB", "CC")

        for (elem in list) {
            println(elem)
        }

        list.forEach {
            println(it)
        }

        when (3) {
            1 -> println("明日")
            2 -> println("明後日")
            else -> println("昨日")
        }
    }
}
