class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        val answer = mutableListOf<Int>()

        for (i in 1..maxOf(arrayA.minOrNull()!!, arrayB.minOrNull()!!)) {
            var r1 = true
            var r2 = true
            for (j in arrayA.indices) {
                if (r1 && arrayA[j] % i == 0 && arrayB[j] % i != 0) continue else r1 = false
                if (r2 && arrayA[j] % i != 0 && arrayB[j] % i == 0) continue else r2 = false
                if (!r1 && !r2) break
            }
            if (r1 || r2) answer.add(i)
        }

        return answer.maxOrNull() ?: 0
    }
}