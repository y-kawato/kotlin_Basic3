package jp.co.stv_tech.test116

open class Designner(name: String,age: Int,gender: String,address: String,salary: Int,numberOfProject: Int) :Employee(name, age, gender, address, salary, numberOfProject){
    private val money = salary + (10000*numberOfProject)

    private val introduce = "「${name}さんは、${age}歳の${gender}で給料は${money}円${address}住みです。」"
    fun computeYearlyPay() {

        println(introduce)
    }
}