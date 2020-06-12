package jp.co.stv_tech.test115

class FiveYearsTeacher() : Teacher(){
    override fun calculateSalary(name:String,age:Int,gender:String,salary:Double) {
        introduce = "「${name}さんは、${age}歳で給料は${salary*1.1}円です。」"
        println(introduce)
    }


}