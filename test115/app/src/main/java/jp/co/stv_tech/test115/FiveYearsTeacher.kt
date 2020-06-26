package jp.co.stv_tech.test115

class FiveYearsTeacher(name:String,age:Int,gender:String,salary:Double) : Teacher("山田孝之",23,"男性",200000.0){
    private val introduce = "「${name}さんは、${age}歳で給料は${salary*1.1}円です。」"

    fun calculateSalary() {

        println(introduce)
    }
}