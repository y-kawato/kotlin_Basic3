package jp.co.stv_tech.test114

class Account(private val name: String, private val age: Int, private val gender: String, private val lang: String){

    private val introduce =
        when (gender) {
            "男性" -> "「${name}君は、${lang}が得意な${age}歳です。」"
            else -> "「${name}さんは、${lang}が得意な${age}歳です。」"
        }
    fun result() {
        println(introduce)
    }
}