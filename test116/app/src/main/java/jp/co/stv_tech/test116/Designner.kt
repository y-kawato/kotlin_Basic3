package jp.co.stv_tech.test116

open class Designner() :Employee(){

    override fun computeYearlyPay(name: String,age: Int,gender: String,address: String,salary: Int,numberOfProject: Int ) {

        val money = salary + (10000*numberOfProject)

        val introduce = "「${name}さんは、${age}歳の${gender}で給料は${money}円${address}住みです。」"
        println(introduce)
    }
}