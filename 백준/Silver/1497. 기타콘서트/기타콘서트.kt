var max = 0
var result = Int.MAX_VALUE
var arr = arrayOf("")
var pick = intArrayOf()
var canPlay = booleanArrayOf()

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    arr = Array(N) { "" }
    pick = IntArray(N) { -1 }
    canPlay = BooleanArray(M)

    for (i in 0 until N) {
        val (name, info) = readln().split(" ")

        arr[i] = info
    }

    pick(0, 0, N, M)

    println(if (max == 0) -1 else result)
}

fun pick(idx: Int, cnt: Int, n: Int, m: Int) {
    if (canPlay.count { it } > max) {
        max = canPlay.count { it }
        result = cnt
    } else if (canPlay.count { it } == max) {
        result = minOf(result, cnt)
    }

    if (idx >= n || cnt >= n) return

    p@ for (i in idx until n) {
        for (j in 0 until i) {
            if (pick[j] == i) continue@p
        }

        pick[idx] = i
        val temp = canPlay.clone()

        for (j in arr[i].indices) {
            if (arr[i][j] == 'Y') canPlay[j] = true
        }

        pick(i + 1, cnt + 1, n, m)

        pick[idx] = -1
        canPlay = temp
    }
}