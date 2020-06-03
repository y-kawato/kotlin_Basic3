package jp.co.stv_tech.test116

open class Programmer() :Employee("佐藤二朗",50,"男性","東京",400000,10){
    private val rank: Char = 'A'

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
