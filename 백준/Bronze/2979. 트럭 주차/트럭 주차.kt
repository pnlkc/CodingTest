fun main() {
    val (A, B, C) = readln().split(" ").map { it.toInt() }
    val (a1, a2) = readln().split(" ").map { it.toInt() }
    val (b1, b2) = readln().split(" ").map { it.toInt() }
    val (c1, c2) = readln().split(" ").map { it.toInt() }
    val time = IntArray(101)
    var sum = 0

    (a1 until a2).forEach { time[it]++ }
    (b1 until b2).forEach { time[it]++ }
    (c1 until c2).forEach { time[it]++ }

    for (i in 1..100) {
        when (time[i]) {
            1 -> sum += A
            2 -> sum += B * 2
            3 -> sum += C * 3
        }
    }

    println(sum)
}