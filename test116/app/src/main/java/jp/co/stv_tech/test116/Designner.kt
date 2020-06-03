package jp.co.stv_tech.test116

open class Designner() :Employee("山田花子",23,"女性","東京",200000,5){

    open fun computeYearlyPay() {

        val money = salary + (10000*numberOfProject)

        val introduce = "「${name}さんは、${age}歳の${gender}で給料は${money}円${address}住みです。」"
        println(introduce)

    }

}