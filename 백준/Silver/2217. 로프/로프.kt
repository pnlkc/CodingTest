fun main() {
    val N = readln().toInt()
    val list = mutableListOf<Int>()
    var max = 0

    for (i in 1..N) {
        val num = readln().toInt()

        list.add(num)
    }

    list.sortDescending()

    for (i in 1..N) {
        max = maxOf(max, list[i - 1] * i)
    }

    println(max)
}