// https://level.goorm.io/exam/353872/%EA%B3%84%ED%9A%8D-%EB%8F%84%EC%8B%9C/quiz/1

import kotlin.math.abs

fun main() {
    val (n, m) = readLine()!!.trim().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    val list = mutableListOf < List<Int>>()

    for (i in 0 until n) {
        val input = readLine()!!.trim().split(" ").map { it.toInt() }

        for (j in 0 until m) {
            map[i][j] = input[j]

            if (input[j] == 1) list.add(listOf(i, j))
        }
    }

    println(abs(list[0][0] - list[1][0]) + abs(list[0][1] - list[1][1]))
}
