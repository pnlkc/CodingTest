fun main() {
    val n = readln().toInt()
    val arr = BooleanArray(1_000_001) { true }
    val result = mutableListOf<Int>()

    for (i in 2..1_000_000) {
        if (!arr[i]) continue

        var num = i + i

        while (num <= 1_000_000) {
            arr[num] = false
            num += i
        }
    }

    p@ for (i in 2..n) {
        if (!arr[i]) continue

        val set = mutableSetOf(i)
        var num = i

        while (true) {
            val prev = set.size
            var temp = 0

            for (j in num.toString().indices) {
                temp += (num.toString()[j] - '0') * (num.toString()[j] - '0')
            }

            if (temp == 1) {
                result.add(i)
                continue@p
            }

            num = temp
            set.add(num)
            if (prev == set.size) break
        }
    }

    println(result.joinToString("\n"))
}