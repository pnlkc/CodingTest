fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<String>()
    val cntArr = Array(M) { IntArray(4) }
    var result = ""
    var sum = 0

    for (i in 0 until N) {
        list.add(readln())
    }

    for (i in 0 until  N) {
        for (j in 0 until M) {
            when (list[i][j]) {
                'A' -> cntArr[j][0] = cntArr[j][0] + 1
                'C' -> cntArr[j][1] = cntArr[j][1] + 1
                'G' -> cntArr[j][2] = cntArr[j][2] + 1
                'T' -> cntArr[j][3] = cntArr[j][3] + 1
            }
        }
    }

    for (i in 0 until M) {
        val max = cntArr[i].max()

        for (j in 0 until 4) {
            if (cntArr[i][j] == max) {
                when (j) {
                    0 -> result += 'A'
                    1 -> result += 'C'
                    2 -> result += 'G'
                    3 -> result += 'T'
                }
                break
            }
        }
    }

    for (i in 0 until M) {
        for (j in 0 until 4) {
            when (result[i]) {
                'A' -> if (j == 0) continue
                'C' -> if (j == 1) continue
                'G' -> if (j == 2) continue
                'T' -> if (j == 3) continue
            }

            sum += cntArr[i][j]
        }
    }

    println(result)
    println(sum)
}