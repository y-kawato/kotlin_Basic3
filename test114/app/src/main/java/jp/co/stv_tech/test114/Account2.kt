package jp.co.stv_tech.test114

class Account2{
    var name: String = "佐藤二朗"
    var age: Int = 50
    var gender: String = "男性"
    var lang: String = "swift"



    private val introduce =
        when (gender) {
            "男性" -> "「${name}君は、${lang}が得意な${age}歳です。」"
            else -> "「${name}さんは、${lang}が得意な${age}歳です。」"
        }
    fun result() {
        println(introduce)
    }

}