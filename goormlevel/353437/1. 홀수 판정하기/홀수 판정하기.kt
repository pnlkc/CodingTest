// https://level.goorm.io/exam/353437/%ED%99%80%EC%88%98-%ED%8C%90%EC%A0%95%ED%95%98%EA%B8%B0/quiz/1

fun main() {
    val n = readLine()!!.toLong()

    println(
        if (n % 2 != 0L) n else -1
    )
}
