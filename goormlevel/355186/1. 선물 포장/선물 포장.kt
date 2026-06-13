// https://level.goorm.io/exam/355186/%EC%84%A0%EB%AC%BC-%ED%8F%AC%EC%9E%A5/quiz/1

fun main() {
    val (r, c, h) = readLine()!!.split(" ").map { it.toLong() }

    val r1 = (r + c) * (r + c) + h * h
    val r2 = (r + h) * (r + h) + c * c
    val r3 = (c + h) * (c + h) + r * r
    
    println(minOf(r1, r2, r3))
}
