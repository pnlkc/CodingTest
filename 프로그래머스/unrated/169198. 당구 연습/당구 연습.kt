class Solution {
    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
        val answer = IntArray(balls.size) { 0 }
        balls.forEachIndexed { index, ints ->
            answer[index] = calc(m, n, startX, startY, ints)
        }
        return answer
    }

    fun calc(m: Int, n: Int, startX: Int, startY: Int, ball: IntArray): Int {
        val result = IntArray(4) { Int.MAX_VALUE }

        val diffY = maxOf(startY, ball[1]) - minOf(startY, ball[1])

        // 좌측
        if (!(startY == ball[1] && startX > ball[0])) {
            val x = startX + ball[0]
            result[0] = diffY * diffY + x * x
        }

        // 우측
        if (!(startY == ball[1] && startX < ball[0])) {
            val x = m - startX + m - ball[0]
            result[1] = diffY * diffY + x * x
        }

        val diffX = maxOf(startX, ball[0]) - minOf(startX, ball[0])

        // 상단
        if (!(startX == ball[0] && startY < ball[1])) {
            val y = n - startY + n - ball[1]
            result[2] = diffX * diffX + y * y
        }

        // 하단
        if (!(startX == ball[0] && startY > ball[1])) {
            val y = startY + ball[1]
            result[3] = diffX * diffX + y * y
        }

        return result.minOrNull()!!
    }
}