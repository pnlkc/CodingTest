fun main() {
    val str = readln()
    val list = readln().split(" ").map { it.toInt() }
    var max = 0

    for (i in 0 until 12) {
        if (str[i] == 'N') continue

        when (i) {
            in 0..5 -> max = maxOf(max, (list.count { it == i + 1 } + 2) * (i + 1))
            6 -> list.forEach { num -> if (list.count { it == num } >= 2) max = maxOf(max, num * 4) }
            7 -> list.forEach { num ->
                if (list.count { it == num } == 3) max = maxOf(max, num * 3 + if (num == 6) 10 else 12)
                if (list.count { it == num } == 2) max = maxOf(max, list.max() * 3 + list.min() * 2)
            }
            8 -> if (list.distinct().count { it in 1..5 } == 3) max = maxOf(max, 30)
            9 -> if (list.distinct().count { it in 2..6 } == 3) max = maxOf(max, 30)
            10 -> if (list.distinct().size == 1) max = maxOf(max, 50)
            11 -> max = maxOf(max, list.sum() + 12)
        }
    }

    println(max)
}