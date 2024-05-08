fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val (N, M) = readln().split(" ").map { it.toInt() }
        val A = readln().split(" ").map { it.toInt() }.sortedDescending()
        val B = readln().split(" ").map { it.toInt() }.sortedDescending()
        var aIdx = 0
        var bIdx = 0
        var sum = 0

        while (aIdx < N) {
            if (A[aIdx] > B[bIdx]) {
                sum += M - bIdx
                aIdx++
            } else {
                if (++bIdx >= M) break
            }
        }

        sb.appendLine(sum)
    }

    print(sb)
}