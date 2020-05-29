package jp.co.stv_tech.test116

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val designner = Designner()
        designner.computeYearlyPay()

        val programmer = Programmer()
        programmer.computeYearlyPay()


    }
    open class Employee() {
        var name: String = "山田花子"
        var age: Int = 23
        var gender: String = "女性"
        var address: String = "東京"
        var salary: Int = 200000




    }
    open class Designner() :Employee(){
        private val numberOfProject: Int = 5
        open fun computeYearlyPay() {

            val money = salary + (10000*numberOfProject)

            val introduce = "「${name}さんは、${age}歳の${gender}で給料は${money}円${address}住みです。」"
            println(introduce)

        }

    }
    open class Programmer() :Employee(){
        private val rank: Char = 'A'
        private val numberOfProject: Int = 5

        private fun getBonusByRank(): Int {

            return when (rank) {
                'A' -> {
                    10000
                }
                'B' -> {
                    7000
                }
                'C' -> {
                    4000
                }


                else -> 0
            }

        }
        open fun computeYearlyPay() {
            val money = salary + (10000*numberOfProject) + getBonusByRank()

            val introduce = "「${name}さんは、${age}歳の${gender}で給料は${money}円${address}住みです。」"
            println(introduce)

        }

    }


}
