// 분할정복(DivideAndConquer) 알고리즘은 문제를 더 작은 부분 문제로 나누어 해결하는 알고리즘입니다.
// 일반적으로 분할정복 알고리즘은 O(N * logN)의 시간복잡도를 가집니다.
// 분할정복은 부분 문제가 서로의 결과에 영향을 주지 않고 독립적인 경우에만 사용할 수 있습니다.
// 백준 10830번 행렬 제곱
class 분할정복 {
    // 행렬 거듭제곱 분할정복 처리 문제
    fun example() {
        val (n, b) = readln().split(" ").map { it.toLong() }
        val a = Array(n.toInt()) { readln().split(" ").map { it.toInt() % 1000 }.toIntArray() }
        val result = calc(a, b)
        println(result.joinToString("\n") { it.joinToString(" ") })
    }

    // 거듭 제곱 분할정복
    fun calc(a: Array<IntArray>, b: Long): Array<IntArray> {
        return when (b) {
            1L -> a
            else -> {
                val r = calc(a, b / 2)
                val multiplyR = multiply(r, r)
                if (b % 2 == 0L) multiplyR
                else multiply(a, multiplyR)
            }
        }
    }

    // 행렬 곱셉 처리
    fun multiply(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
        val n = a.size
        val result = Array(n) { IntArray(n) }
        for (x in 0 until n) {
            for (y in 0 until n) {
                var sum = 0
                for (z in 0 until n) {
                    sum += a[x][z] * b[z][y]
                    sum %= 1000
                }
                result[x][y] = sum
            }
        }
        return result
    }
}
