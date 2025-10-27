fun main() {
    val n = readln().toInt()
    val arr = BooleanArray(1_000_001) { true }
    val check = IntArray(1_000_001)
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
        if (!arr[i] || check[i] == 2) continue

        val set = mutableSetOf(i)
        var num = i

        while (true) {
            val prev = set.size
            var temp = num
            var next = 0

            while (temp != 0) {
                next += (temp % 10) * (temp % 10)
                temp /= 10
            }

            if (check[next] != 0) {
                if (check[next] == 1) result.add(i)
                continue@p
            }

            if (next == 1) {
                result.add(i)

                set.forEach { check[it] = 1 }
                continue@p
            }

            num = next
            set.add(num)
            if (prev == set.size) break
        }

        check[i] = 2
    }

    println(result.joinToString("\n"))
}