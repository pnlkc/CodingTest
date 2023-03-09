fun main() {
    var answer = 64
    val (y, x) = readln().split(" ").map { it.toInt() }
    val array = Array(y) { charArrayOf() }

    for (i in 0 until y) {
        val input = readln().toCharArray()
        array[i] = input
    }

    for (i in 0..y - 8) {
        for (j in 0..x - 8) {
            val firstChar = array[i][j]
            var count = 0

            for (k in 0..7) {
                for (l in 0..7) {
                    when {
                        k % 2 == 0 -> {
                            if (l % 2 == 0 && array[i + k][j + l] != firstChar) count++
                            else if (l % 2 != 0 && array[i + k][j + l] == firstChar) count++
                        }
                        else -> {
                            if (l % 2 == 0 && array[i + k][j + l] == firstChar) count++
                            else if (l % 2 != 0 && array[i + k][j + l] != firstChar) count++
                        }
                    }
                }
            }

            count = minOf(count, 64 - count)
            if (answer > count) answer = count
        }
    }

    println(answer)
}