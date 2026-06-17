// https://level.goorm.io/exam/352968/%EC%82%BC%EA%B0%81%ED%98%95-%EB%B6%84%EB%A5%98/quiz/1

fun main() {
    val (a, b, c) = readLine()!!.trim().split(" ").map { it.toInt() }

    println(
        when {
            a == 60 && b == 60 && c == 60 -> 1
            a == b || a == c || b == c -> 2
            else -> 3
        }
    )
}
