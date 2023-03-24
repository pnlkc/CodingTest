class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var answer = intArrayOf(0, 0)

        // 시작 위치 찾기
        p@for (i in park.indices) {
            for (j in park[0].indices) {
                if (park[i][j] == 'S') {
                    answer = intArrayOf(i, j)
                    break@p
                }
            }
        }

        // 각 명령 검증
        routes.forEach {
            answer = isValid(it, answer, park)
        }

        return answer
    }

    // 유효한 명령인지 확인인
    fun isValid(s: String, c: IntArray, park: Array<String>): IntArray {
        val (d, n) = s.split(" ")
        val result = when (d) {
            "E" -> intArrayOf(c[0], c[1] + n.toInt())
            "W" -> intArrayOf(c[0], c[1] - n.toInt())
            "S" -> intArrayOf(c[0] + n.toInt(), c[1])
            else -> intArrayOf(c[0] - n.toInt(), c[1])
        }

        // 범위 밖으로 이동하는 명령
        if(result[0] !in park.indices || result[1] !in park[0].indices) return c

        // 벽에 가로막히는 명령
        for (i in minOf(c[0], result[0])..maxOf(c[0], result[0])) {
            for (j in minOf(c[1], result[1])..maxOf(c[1], result[1])) {
                if (park[i][j] == 'X') return c
            }
        }

        // 유요한 조건이면 실행
        return result
    }
}