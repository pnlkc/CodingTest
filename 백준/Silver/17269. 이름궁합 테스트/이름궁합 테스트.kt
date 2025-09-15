fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val (A, B) = readln().split(" ")
    var nIdx = 0
    var mIdx = 0
    var arr = IntArray(N + M)
    val map = mapOf(
        'A' to 3, 'B' to 2, 'C' to 1, 'D' to 2, 'E' to 4, 'F' to 3, 'G' to 1,
        'H' to 3, 'I' to 1, 'J' to 1, 'K' to 3, 'L' to 1, 'M' to 3, 'N' to 2,
        'O' to 1, 'P' to 2, 'Q' to 2, 'R' to 2, 'S' to 1, 'T' to 2, 'U' to 1,
        'V' to 1, 'W' to 1, 'X' to 2, 'Y' to 2, 'Z' to 1
    )

    while (nIdx + mIdx < N + M) {
        if (nIdx < N) {
            arr[nIdx + mIdx] = map[A[nIdx++]]!!
        }

        if (mIdx < M) {
            arr[nIdx + mIdx] = map[B[mIdx++]]!!
        }
    }
    
    while (arr.size > 2) {
        val temp = IntArray(arr.size - 1)

        for (i in 0 until arr.size - 1) {
            temp[i] = (arr[i] + arr[i + 1]) % 10
        }

        arr = temp
    }

    println("${if (arr[0] == 0) arr[1] else arr.joinToString("")}%")
}