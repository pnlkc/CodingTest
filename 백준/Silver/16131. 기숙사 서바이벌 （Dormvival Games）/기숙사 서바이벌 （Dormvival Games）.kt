import kotlin.math.abs

fun main() {
    val (N, A, B, M) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(N) { it }
    val score = IntArray(N)
    var hong = 0
    var jo = A - 1
    var result = 0
    var max = 0
    var cnt = 0

    if (A - 1 <= B) {
        result++
        max = 1
        cnt = 1
    }

    repeat(M - 1) {
        val add = readln().split(" ").map { it.toInt() }
        val minus = readln().split(" ").map { it.toInt() }

        for (i in 0 until N) {
            score[i] = add[i] - minus[i]
        }

        for (i in 0 until N - 1) {
            var isChange = false

            when {
                score[arr[i]] >= 0 && score[arr[i + 1]] >= 0 -> {
                    if (score[arr[i]] + 2 <= score[arr[i + 1]]) {
                        val temp = arr[i]

                        arr[i] = arr[i + 1]
                        arr[i + 1] = temp
                        isChange = true
                    }
                }
                score[arr[i]] < 0 && score[arr[i + 1]] >= 0 -> {
                    val temp = arr[i]

                    arr[i] = arr[i + 1]
                    arr[i + 1] = temp
                    isChange = true
                }
                score[arr[i]] < 0 && score[arr[i + 1]] < 0 -> {
                    if (score[arr[i]] + 4 <= score[arr[i + 1]]) {
                        val temp = arr[i]

                        arr[i] = arr[i + 1]
                        arr[i + 1] = temp
                        isChange = true
                    }
                }
            }

            hong = if (arr[i] == 0) i else if (arr[i + 1] == 0) i + 1 else hong
            jo = if (arr[i] == A - 1) i else if (arr[i + 1] == A- 1) i + 1 else jo

            if (isChange) {
                score[arr[i]] -= 2
                score[arr[i + 1]] += 2
            }
        }

        if (abs(hong - jo) <= B) {
            result++
            cnt++
            max = maxOf(max, cnt)
        } else {
            cnt = 0
        }
    }

    println("$result $max")
}