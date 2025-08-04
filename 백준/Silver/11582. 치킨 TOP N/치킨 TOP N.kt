var N = 0
var list = mutableListOf<Int>()
var k = 0

fun main() {
    N = readln().toInt()
    list = readln().split(" ").map { it.toInt() }.toMutableList()
    k = readln().toInt()

    sort(k)

    println(list.joinToString(" "))
}

fun sort(num: Int) {
    val s = N / num
    val result = mutableListOf<Int>()

    for (i in 0 until N step s) {
        result += list.slice(i until i + s).sorted()
    }

    list = result
}