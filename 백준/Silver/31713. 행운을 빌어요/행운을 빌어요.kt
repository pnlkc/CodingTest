fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val (A, B) = readln().split(" ").map { it.toInt() }

        // 둘다 필요 없는 경우
        if (A * 3 <= B && A * 4 >= B) {
            sb.appendLine(0)
        }
        // A가 더 필요한 경우
        else if (A * 4 < B) {
            val addA = B / 4 - A + if (B % 4 != 0) 1 else 0
            var addB = 0

            if ((A + addA) * 3 > B) addB = (A + addA) * 3 - B

            sb.appendLine(addA + addB)
        }

        // B가 더 필요한 경우
        else {
            sb.appendLine(A * 3 - B)
        }
    }

    print(sb)
}