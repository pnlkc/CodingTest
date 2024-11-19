fun main() {
    val (y1, m1, d1) = readln().split(" ").map { it.toInt() }
    val (y2, m2, d2) = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf(
        1 to 31,
        3 to 31,
        4 to 30,
        5 to 31,
        6 to 30,
        7 to 31,
        8 to 31,
        9 to 30,
        10 to 31,
        11 to 30,
        12 to 31,
    )

    if (y2 - y1 > 1000 || (y2 - y1 == 1000 && m2 - m1 > 0) || (y2 - y1 == 1000 && m2 - m1 == 0 && d2- d1 >= 0)){
        println("gg")
        return
    }

    var sum1 = 0
    var sum2 = 0

    for (i in 1 until y1) {
        for (j in 1..12) {
            if (j != 2) {
                sum1 += map[j]!!
            } else {
                if (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) {
                    sum1 += 29
                } else {
                    sum1 += 28
                }
            }
        }
    }

    for (i in 1 until m1) {
        if (i != 2) {
            sum1 += map[i]!!
        } else {
            if (y1 % 400 == 0 || (y1 % 4 == 0 && y1 % 100 != 0)) {
                sum1 += 29
            } else {
                sum1 += 28
            }
        }
    }

    sum1 += d1

    for (i in 1 until y2) {
        for (j in 1..12) {
            if (j != 2) {
                sum2 += map[j]!!
            } else {
                if (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) {
                    sum2 += 29
                } else {
                    sum2 += 28
                }
            }
        }
    }

    for (i in 1 until m2) {
        if (i != 2) {
            sum2 += map[i]!!
        } else {
            if (y2 % 400 == 0 || (y2 % 4 == 0 && y2 % 100 != 0)) {
                sum2 += 29
            } else {
                sum2 += 28
            }
        }
    }

    sum2 += d2

    println("D-${sum2 - sum1}")
}