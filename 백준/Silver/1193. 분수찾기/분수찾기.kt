fun main() {
    val input = readln().toInt()
    val lastNum = intArrayOf(0, 0)
    val answer = intArrayOf(0, 1)
    p@for (i in 1..9000) {
        lastNum[0] = lastNum[1] + 1
        lastNum[1] = lastNum[1] + i

        when (i % 2) {
            1 -> {
                for (j in lastNum[0]..lastNum[1]) {
                    if (j == lastNum[0]) {
                        answer[0]++
                    } else {
                        answer[0]--
                        answer[1]++
                    }

                    if (input == j) break@p
                }
            }
            else -> {
                for (j in lastNum[0]..lastNum[1]) {
                    if (j == lastNum[0]) {
                        answer[1]++
                    } else {
                        answer[0]++
                        answer[1]--
                    }

                    if (input == j) break@p
                }
            }
        }
    }

    println(answer.joinToString("/"))
}