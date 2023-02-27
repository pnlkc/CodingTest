class Solution {
    fun solution(A: String, B: String): Int {
        if (A == B) return 0
        var moveA = A
        for (i in 1 until A.length) {
            moveA = moveA.last() + moveA.slice(0 until moveA.lastIndex)
            if (moveA == B) return i
        }
        return -1
    }
}