package jp.co.stv_tech.test115

class TenYearsTeacher() : Teacher(){
    override fun calculateSalary(name:String,age:Int,gender:String,salary:Double) {
        introduce = "「${name}さんは、${age}歳で給料は${salary*1.3}円です。」"
        println(introduce)
    }
}