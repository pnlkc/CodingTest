var result = 0

fun main() {
    var N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }

    calc(N, list, 0)

    println(result)
}

fun calc(n: Int, list: List<Int>, sum: Int) {
    if (n <= 2) {
        result = maxOf(result, sum)
        return
    }

    for (i in 1..n - 2) {
        val temp = list.toMutableList()
        temp.removeAt(i)

        calc(n - 1, temp, sum + list[i - 1] * list[i + 1])
    }
}