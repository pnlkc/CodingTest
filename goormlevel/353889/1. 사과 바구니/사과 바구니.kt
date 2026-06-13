// https://level.goorm.io/exam/353889/%EC%82%AC%EA%B3%BC-%EB%B0%94%EA%B5%AC%EB%8B%88/quiz/1

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    
    println(a % b)
}
