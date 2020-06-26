package jp.co.stv_tech.test115

class TenYearsTeacher(name:String,age:Int,gender:String,salary:Double) : Teacher("山田哲人",23,"男性",200000.0){
    private val introduce = "「${name}さんは、${age}歳で給料は${salary*1.3}円です。」"

    fun calculateSalary() {

        println(introduce)
    }
}