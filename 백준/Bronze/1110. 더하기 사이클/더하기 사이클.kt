fun main() {
    val n = readln().toInt()
    var num = n
    var answer = 0

    while (true) {
        answer++
        if ("${num % 10}${(num / 10 + num % 10) % 10}".toInt().also { num = it } == n) break
    }

    println(answer)
}