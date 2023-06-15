import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()

    val rN = if(m == 0) listOf<Char>() else readln().split(' ').map { it[0] }
    var num = 0
    var length = Int.MAX_VALUE

    for (i in 0..abs(n - 100)) {
        val minus = (n - i).toString()
        val plus = (n + i).toString()
        val result = booleanArrayOf(check(minus, rN), check(plus, rN))
        
        if (result.contains(true)) {
            num = i
            if (result[0]) length = minus.length
            if (result[1]) length = minOf(length, plus.length)
            break
        }
    }

    println(minOf(abs(n.toInt() - 100), num + length))
}

fun check(s: String, list: List<Char>): Boolean {
    s.forEach { if(list.contains(it)) return false }
    return true
}