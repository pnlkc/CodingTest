fun main() {
    val MAX = 100_000
    val arr = BooleanArray(MAX + 1) { true }
    val list = mutableListOf<Int>()
    val possible = mutableListOf<Long>()

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
    
    p@ for (i in list.indices) {
        for (j in i + 1..list.lastIndex) {
            val num = list[i].toLong() * list[j]

            possible.add(num)
            if (num >= MAX) continue@p
        }
    }

    possible.sort()

    repeat(readln().toInt()) {
        val k = readln().toInt()

        println(possible.find { it >= k })
    }
}