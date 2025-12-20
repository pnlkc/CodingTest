import kotlin.math.pow

fun main() {
    val n = readln().toInt()
    val target = readln().toInt(2)
    val arr = IntArray((2.0.pow(n)).toInt()) { it }
    val list = arr.sortedWith(compareBy<Int> { it.toString(2).count { it == '1' } }.thenBy { it.toString(2).reversed() })
    
    println(list.indexOf(target))
}