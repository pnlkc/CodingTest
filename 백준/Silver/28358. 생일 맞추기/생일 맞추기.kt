fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val list = readln().split(" ").map { it.toInt() }
        val mArr = BooleanArray(13)
        val arr = IntArray(13)

        for (i in 0 until 10) {
            for (j in 0 until 10) {
                if ((i != 0 && list[i] == 1) || list[j] == 1) continue

                val m = "$i$j".toInt()

                if (m in 1..12) mArr[m] = true
            }
        }

        for (i in 0 until 10) {
            for (j in 0 until 10) {
                if ((i != 0 && list[i] == 1) || list[j] == 1) continue

                val d = "$i$j".toInt()

                for (k in 1..12) {
                    if (mArr[k]) {
                        when (k) {
                            2 -> if (d in 1..29) arr[k]++
                            1, 3, 5, 7, 8, 10, 12 -> if (d in 1..31) arr[k]++
                            else -> if (d in 1..30) arr[k]++
                        }
                    }
                }
            }
        }

        sb.appendLine(arr.sum())
    }

    print(sb)
}