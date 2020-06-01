package jp.co.stv_tech.test115

class TenYearsTeacher() : MainActivity.Teacher(){
    override fun result() {
        introduce = "「${name}さんは、${age+10}歳で給料は${salary*1.3}円です。」"
        println(introduce)
    }
}