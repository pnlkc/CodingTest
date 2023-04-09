import java.util.*

fun main() {
    val n = readln().toInt()
    val arr1 = StringTokenizer(readln())
    val m = readln().toInt()
    val arr2 = StringTokenizer(readln())
    val map = mutableMapOf<Int, Boolean>()
    val s = StringBuilder()

    repeat(n) { map[arr1.nextToken().toInt()] = true }

    repeat(m) { s.appendLine(if (map[arr2.nextToken().toInt()] != null) 1 else 0) }

    println(s.toString())
}