fun main() {
    val (A, B) = readln().split(" ").map { it.toInt() }
    val (C, D) = readln().split(" ").map { it.toInt() }
    val isPN = BooleanArray(1001) { true }
    val count = IntArray(1001)

    isPN[0] = false
    isPN[1] = false

    for (i in 2..1000) {
        if (!isPN[i]) continue

        var num = i * 2

        while (num <= 1000) {
            isPN[num] = false
            num += i
        }
    }

    for (i in A..B) {
        if (isPN[i]) count[i] += 1
    }

    for (i in C..D) {
        if (isPN[i]) count[i] += 2
    }

    p@ for (i in 0 until 1000) {
        if (i % 2 == 0) {
            for (j in A..B) {
                if (count[j] == 3) {
                    count[j] = 0
                    continue@p
                }
            }

            for (j in A..B) {
                if (count[j] == 1) {
                    count[j] = 0
                    continue@p
                }
            }
        } else {
            for (j in C..D) {
                if (count[j] == 3) {
                    count[j] = 0
                    continue@p
                }
            }

            for (j in C..D) {
                if (count[j] == 2) {
                    count[j] = 0
                    continue@p
                }
            }
        }

        println(if (i % 2 == 0) "yj" else "yt")
        break
    }
}