fun main() {
    val MAX = 100_000
    val arr = BooleanArray(MAX + 1) { true }
    val list = mutableListOf<Int>()

    for (i in 2 until MAX) {
        var num = i + i

        while (num <= MAX) {
            arr[num] = false
            num += i
        }
    }

    for (i in 2..MAX) {
        if (arr[i]) list.add(i)
    }

    repeat(readln().toInt()) {
        val k = readln().toInt()
        var min = Long.MAX_VALUE

        for (i in list.indices) {
            for (j in i + 1..list.lastIndex) {
                val num = list[i].toLong() * list[j]

                if (num >= k) min = minOf(min, num)
            }
        }

        println(min)
    }
}