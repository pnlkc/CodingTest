import kotlin.math.ceil
import kotlin.math.floor

data class Data(val cnt: Int, val s: Int, val e: Int)

fun main() {
    val (N, T) = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf<String, Data>()
    var left = N
    var s = 0

    for (i in 0 until T) {
        val (t, n) = readln().split(" ")
        var num = 0

        if (n.last() == '%') {
            val per = n.dropLast(1).toInt()

            num = floor(left.toDouble() * per / 100).toInt()
        } else {
            num = minOf(left, n.toInt())
        }

        map[t] = Data(num, s + 1, s + num)
        s += num
        left -= num
    }

    if (left != 0) {
        println("Invalid System")
        return
    }

    val user = readln()

    if (user.last().isDigit()) {
        if (map[user.dropLast(1)] == null) {
            println("Liar")
            return
        }

        val (cnt, s, e) = map[user.dropLast(1)]!!
        val div = ceil(cnt.toDouble() / 4).toInt()
        var num = cnt
        val a = minOf(num, div)
        num -= a
        val b = minOf(num, div)
        num -= b
        val c = minOf(num, div)
        num -= c
        val d = minOf(num, div)

        when (user.last().digitToInt()) {
            1 -> {
                if (a == 0) {
                    println("Liar")
                    return
                }
                println("$s ${s + a - 1}")
            }
            2 -> {
                if (b == 0) {
                    println("Liar")
                    return
                }
                println("${s + a} ${s + a + b - 1}")
            }
            3 -> {
                if (c == 0) {
                    println("Liar")
                    return
                }
                println("${s + a + b} ${s + a + b + c - 1}")
            }
            4 -> {
                if (d == 0) {
                    println("Liar")
                    return
                }
                println("${s + a + b + c} ${s + a + b + c + d - 1}")
            }
        }
    } else {
        if(map[user] == null || map[user]!!.cnt == 0) {
            println("Liar")
            return
        }

        println("${map[user]!!.s} ${map[user]!!.e}")
    }
}