import kotlin.math.abs

var n = 0
var max = 0
var arr = listOf<Int>()

fun main() {
    n = readln().toInt()
    arr = readln().split(" ").map { it.toInt() }

    pick(mutableListOf())

    println(max)
}

fun pick(list: MutableList<Int>) {
    if (list.size == n) {
        calc(list)
        return
    }

    for (i in 0 until n) {
        if (!list.contains(i)) {
            val temp = list.toMutableList()
            temp.add(i)
            pick(temp)
        }
    }
}

fun calc(list: MutableList<Int>) {
    var sum = 0

    for (i in 0 until n - 1) {
        sum += abs(arr[list[i]] - arr[list[i + 1]])
    }

    max = maxOf(max, sum)
}