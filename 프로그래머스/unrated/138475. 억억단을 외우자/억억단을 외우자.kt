class Solution {
    fun solution(e: Int, starts: IntArray): IntArray {
        val answer = IntArray(starts.size) { 0 }
        val listA = IntArray(e + 1) { 0 }
        val listB = IntArray(e + 1) { 0 }
        var c = intArrayOf(-1, -1)

        for (i in 1..e) {
            for (j in 1..e) {
                if (i * j > e) break
                else listA[i * j]++
            }
        }

        for (i in e downTo 1) {
            if (listA[i] > c[0]) c = intArrayOf(listA[i], i) else if (listA[i] == c[0]) c[1] = i
            listB[i] = c[1]
        }

        for (i in starts.indices) {
            answer[i] = listB[starts[i]]
        }

        return answer
    }
}