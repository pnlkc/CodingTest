// https://level.goorm.io/exam/353615/%ED%96%89%EB%A0%AC%EC%9D%98-%ED%95%A9-%EA%B5%AC%ED%95%98%EA%B8%B0/quiz/1

fun main() {
    val sb = StringBuilder()
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val a = Array(n) { listOf<Int>() }
    val b = Array(n) { listOf<Int>() }

    for (i in 0 until n) {
        val input = readLine()!!.split(" ").map { it.toInt() }

        a[i] = input
    }

    for (i in 0 until n) {
        val input = readLine()!!.split(" ").map { it.toInt() }

        b[i] = input
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (j != 0) sb.append(" ")

            sb.append(a[i][j] + b[i][j])
        }

        sb.appendLine()
    }

    print(sb)
}
