package jp.co.stv_tech.test115

class TenYearsTeacher() : Teacher("山田花子",23,"女性",200000.0){
    override fun result() {
        introduce = "「${name}さんは、${age+10}歳で給料は${salary*1.3}円です。」"
        println(introduce)
    }
}