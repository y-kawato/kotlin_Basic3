package jp.co.stv_tech.test114

class Account1{
    private var name: String = "山田花子"
    private var age: Int = 23
    private var gender: String = "女性"
    private var lang: String = "kotlin"



    private val introduce =
        when (gender) {
            "男性" -> "「${name}君は、${lang}が得意な${age}歳です。」"
            else -> "「${name}さんは、${lang}が得意な${age}歳です。」"
        }
    fun result() {
        println(introduce)
    }

}