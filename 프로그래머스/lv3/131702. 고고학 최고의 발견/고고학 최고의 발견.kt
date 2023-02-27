class Solution {
    var answer: Int = 192
    fun solution(clockHands: Array<IntArray>): Int {
        calc(0, 0, 0, clockHands.sumOf { it.sum() }, clockHands.map { it.clone() })
        return answer
    }

    fun calc(a: Int, b: Int, n: Int, sum: Int, clockHands: List<IntArray>) {
        if (sum == 0) {
            if (answer > n) answer = n
        } else if (answer >= n && a in clockHands.indices) {
            when (a) {
                0 -> {
                    for (i in 0..3) {
                        val temp = clockHands.map { it.clone() }
                        var nSum = sum - temp[a][b]
                        temp[a][b] = (temp[a][b] + i) % 4
                        nSum += temp[a][b]

                        nSum -= temp[1][b]
                        temp[1][b] = (temp[1][b] + i) % 4
                        nSum += temp[1][b]

                        if (b + 1 in clockHands.indices) {
                            nSum -= temp[a][b + 1]
                            temp[a][b + 1] = (temp[a][b + 1] + i) % 4
                            nSum += temp[a][b + 1]
                        }
                        if (b - 1 in clockHands.indices) {
                            nSum -= temp[a][b - 1]
                            temp[a][b - 1] = (temp[a][b - 1] + i) % 4
                            nSum += temp[a][b - 1]
                        }

                        if (b + 1 in clockHands.indices) calc(a, b + 1, n + i, nSum, temp)
                        else calc(1, 0, n + i, nSum, temp)
                    }
                }
                else -> {
                    if (clockHands[a - 1][b] != 0) {
                        val temp = clockHands.map { it.clone() }
                        val need = 4 - temp[a - 1][b]

                        var nSum = sum - temp[a][b]
                        temp[a][b] = (temp[a][b] + need) % 4
                        nSum += temp[a][b]

                        if (a + 1 in clockHands.indices) {
                            nSum -= temp[a + 1][b]
                            temp[a + 1][b] = (temp[a + 1][b] + need) % 4
                            nSum += temp[a + 1][b]
                        }

                        nSum -= temp[a - 1][b]
                        temp[a - 1][b] = (temp[a - 1][b] + need) % 4
                        nSum += temp[a - 1][b]

                        if (b + 1 in clockHands.indices) {
                            nSum -= temp[a][b + 1]
                            temp[a][b + 1] = (temp[a][b + 1] + need) % 4
                            nSum += temp[a][b + 1]
                        }
                        if (b - 1 in clockHands.indices) {
                            nSum -= temp[a][b - 1]
                            temp[a][b - 1] = (temp[a][b - 1] + need) % 4
                            nSum += temp[a][b - 1]
                        }

                        if (b + 1 in clockHands.indices) calc(a, b + 1, n + need, nSum, temp)
                        else calc(a + 1, 0, n + need, nSum, temp)
                    } else {
                        if (b + 1 in clockHands.indices) calc(a, b + 1, n, sum, clockHands)
                        else calc(a + 1, 0, n, sum, clockHands)
                    }
                }
            }
        }
    }
}