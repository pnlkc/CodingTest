fun main() {
    val N = readln().toInt()

    if (N == 1) {
        println('A')
        return
    }

    val list = readln().split(" ").map { it.toInt() }

    if (list.distinct().size == 1) {
        println(list[0])
        return
    }

    if (N == 2) {
        println('A')
        return
    }

    val aT = list[1] - list[2]
    val bT = list[0] * list[2] - list[1] * list[1]
    val bot = list[0] - list[1]

    if (bot == 0 || aT % bot != 0 || bT % bot != 0) {
        println('B')
        return
    }

    val a = aT / bot
    val b = bT / bot

    for (i in 3 until N) {
        if (list[i] != list[i - 1] * a + b) {
            println('B')
            return
        }
    }

    println(list.last() * a + b)
}