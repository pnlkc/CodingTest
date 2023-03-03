fun main() {
    val num = readln().toInt()
    val answer = intArrayOf((num / 5) * 5, num - ((num / 5) * 5))
    while (answer[1] % 3 != 0) {
        answer[0] -= 5
        answer[1] += 5
        if (answer[0] < 0) break
    }
    if (answer[0] < 0) println(-1) else println(answer[0] / 5 + answer[1] / 3)
}