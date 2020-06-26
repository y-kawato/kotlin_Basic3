package jp.co.stv_tech.test115

open class Teacher(name:String,age:Int,gender:String,salary:Double){
    private var name:String = ""
    private var age:Int = 0
    private var gender:String = ""
    private var salary:Double = 0.0

    private val introduce = "「${name}さんは、${age}歳で給料は${salary*1.3}円です。」"
}