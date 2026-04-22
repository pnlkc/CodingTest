fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val answer = intArrayOf(0, 0)

    for (i in 1..a) {
        if (a % i == 0) {
            answer[0]++
            answer[1] = i

            if (answer[0] == b) break
        }
    }

    println(if (answer[0] < b) 0 else answer[1])
}