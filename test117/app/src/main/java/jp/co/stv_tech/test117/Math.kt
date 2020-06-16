package jp.co.stv_tech.test117


interface Result{
    fun result(resultValue:Int)
}
class Math (private var result:Result) {
    private val a:Int = 2
    private val b:Int = 3
    fun calculate(){
        val math:Int = a + b
        result.result(math)
    }
}