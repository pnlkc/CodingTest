fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val operator = readln().split(" ").map { it.toInt() }.toIntArray()
    val answer = intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE)

    calc(1, n, list, operator, list[0], answer)

    println(answer.joinToString("\n"))
}

fun calc(i: Int, n: Int, list: List<Int>, operator: IntArray, result: Int, answer: IntArray) {
    if (i == n) {
        answer[0] = maxOf(answer[0], result)
        answer[1] = minOf(answer[1], result)
        return
    }

    for (index in 0..3) {
        if (operator[index] > 0) {
            val newResult = when (index) {
                0 -> result + list[i]
                1 -> result - list[i]
                2 -> result * list[i]
                else -> result / list[i]
            }
            operator[index]--
            calc(i + 1, n, list, operator, newResult, answer)
            operator[index]++
        }
    }
}
