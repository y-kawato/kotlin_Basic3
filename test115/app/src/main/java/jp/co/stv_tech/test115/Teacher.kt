package jp.co.stv_tech.test115

open class Teacher(){
    private var name:String = ""
    private var age:Int = 0
    private var gender:String = ""
    private var salary:Double = 0.0

    var introduce = "「${name}さんは、${age}歳で給料は${salary}円です。」"

    open fun calculateSalary(name:String,age:Int,gender:String,salary:Double){

        println(introduce)
    }
}