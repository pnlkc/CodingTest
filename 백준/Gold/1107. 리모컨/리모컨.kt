import kotlin.math.abs

fun main() {
    val n = readln()
    val m = readln().toInt()

    val rN = if(m == 0) listOf<Char>() else readln().split(' ').map { it[0] }
    var num = 0
    var length = Int.MAX_VALUE

    for (i in 0..abs(n.toInt() - 100)) {
        val minus = (n.toInt() - i).toString()
        val plus = (n.toInt() + i).toString()

        when {
            check(minus, rN) && check(plus, rN) -> {
                num = i
                length = minOf((n.toInt() - i).toString().length, (n.toInt() + i).toString().length)
                break
            }
            check(minus, rN) -> {
                num = i
                length = (n.toInt() - i).toString().length
                break
            }
            check(plus, rN) -> {
                num = i
                length = (n.toInt() + i).toString().length
                break
            }
        }
    }

    println(minOf(abs(n.toInt() - 100), num + length))
}

fun check(s: String, list: List<Char>): Boolean {
    s.forEach { if(list.contains(it)) return false }
    return true
}