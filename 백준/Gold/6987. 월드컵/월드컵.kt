val input = Array(6) { IntArray(3) }
val arr = Array(6) { IntArray(3) }
val match = arrayOf(
    intArrayOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4),
    intArrayOf(1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5)
)
var result = false

fun main() {
    val sb = StringBuilder()

    for (tc in 1..4) {
        result = false
        val temp = readln().split(" ").map { it.toInt() }

        for (i in 0 until 18) {
            input[i / 3][i % 3] = temp[i]
        }

        calc(0)
        sb.append(if (result) "1" else "0")
        if (tc != 4) sb.append(" ")
    }

    println(sb)
}

fun calc(round: Int) {
    if (result) return

    if (round == 15) {
        result = isValid()
        return
    }

    // a가 이긴 경우
    arr[match[0][round]][0]++
    arr[match[1][round]][2]++
    calc(round + 1)
    arr[match[0][round]][0]--
    arr[match[1][round]][2]--

    // b가 이긴 경우
    arr[match[0][round]][2]++
    arr[match[1][round]][0]++
    calc(round + 1)
    arr[match[0][round]][2]--
    arr[match[1][round]][0]--

    // 비긴 경우
    arr[match[0][round]][1]++
    arr[match[1][round]][1]++
    calc(round + 1)
    arr[match[0][round]][1]--
    arr[match[1][round]][1]--
}

fun isValid(): Boolean {
    for (i in 0 until 6) {
        for (j in 0 until 3) {
            if (input[i][j] != arr[i][j]) return false
        }
    }

    return true
}