package jp.co.stv_tech.test117

class Math(private var result:Result) {

    fun calculate(a: Int,b: Int){
        val math:Int = a + b
        result.result(math)
    }
}
