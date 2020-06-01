package jp.co.stv_tech.test115

class FiveYearsTeacher() : MainActivity.Teacher(){
    override fun result() {
        introduce = "「${name}さんは、${age+5}歳で給料は${salary*1.1}円です。」"
        println(introduce)
    }


}