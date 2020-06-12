package jp.co.stv_tech.test116

open class Employee() {
    private var name:String = ""
    private var age:Int = 0
    private var gender:String = ""
    private var address:String = ""
    private var salary:Double  = 0.0
    private var numberOfProject:Int = 0
    open fun computeYearlyPay(name: String,age: Int,gender: String,address: String,salary: Int,numberOfProject: Int ) {

        val money = salary + (10000*numberOfProject)

        val introduce = "「${name}さんは、${age}歳の${gender}で給料は${money}円${address}住みです。」"
        println(introduce)

    }
}