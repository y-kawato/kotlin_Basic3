package jp.co.stv_tech.test115

open class Teacher(var name: String,var age:Int,var gender: String,var salary: Double){


    var introduce = "「${name}さんは、${age}歳で給料は${salary}円です。」"

    open fun result() {
        println(introduce)
    }
}