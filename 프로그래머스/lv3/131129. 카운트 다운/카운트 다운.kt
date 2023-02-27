class Solution {
    fun solution(target: Int): IntArray {
        val single = mutableListOf(50)
        val doubleTriple = mutableListOf<Int>()
        single.addAll(1..20)
        single.map { it * 2 }.forEach { if (!single.contains(it)) doubleTriple.add(it) }
        single.map { it * 3 }.forEach { if (!single.contains(it)) doubleTriple.add(it) }
        val allList = single + doubleTriple

        val sixty = intArrayOf(target / 60, target % 60)

        return calc(sixty, doubleTriple, allList)
    }

    fun calc(sixty: IntArray, dT: List<Int>, aL: List<Int>): IntArray {
        var count = 0
        while (sixty[0] > 0) {
            when {
                sixty[1] >= 50 -> {
                    if (aL.contains(sixty[1])) {
                        break
                    } else {
                        count += 2
                        sixty[0]--
                        sixty[1] -= 40
                    }
                }
                else -> {
                    var n = -1
                    for (i in 1..5) {
                        if (i > sixty[0]) break
                        val newNum = 10 * i + sixty[1]
                        if (newNum in 1..60 && aL.contains(newNum)) {
                            n = i
                        }
                    }
                    if (n != -1) {
                        sixty[0] -= n
                        sixty[1] = 10 * n + sixty[1]
                        count += n
                    } else {
                        if (sixty[1] >= 40 && !aL.contains(sixty[1])) {
                            count += 2
                            sixty[0]--
                            sixty[1] -= 40
                        } else {
                            break
                        }
                    }
                }
            }
        }

        val result = when {
            sixty[1] == 0 -> intArrayOf(0, 0)
            sixty[1] <= 20 -> intArrayOf(1, 1)
            sixty[1] <= 40 -> if (dT.contains(sixty[1])) intArrayOf(1, 0) else intArrayOf(2, 2)
            sixty[1] == 50 -> intArrayOf(1, 1)
            else -> if (dT.contains(sixty[1])) intArrayOf(1, 0) else intArrayOf(2, 1)
        }

        return intArrayOf(sixty[0] + count + result[0], count + result[1])
    }
}