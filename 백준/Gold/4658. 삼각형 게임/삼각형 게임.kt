data class Data(var one: Int, var two: Int, var three: Int) {
    fun rotate(): Data {
        return Data(three, one, two)
    }

    fun check(num: Int): Boolean {
        return one == num
    }
}

val arr = Array(6) { Data(0, 0, 0) }
var isUsed = BooleanArray(6)
var max = -1

fun main() {
    val sb = StringBuilder()

    while (true) {
        isUsed = BooleanArray(6)
        max = -1

        for (i in 0..5) {
            val (one, two, three) = readln().split(" ").map { it.toInt() }

            arr[i] = Data(one, two, three)
        }

        isUsed[0] = true

        for (i in 0..2) {
            calc(arr[0].three, 1, arr[0].two, arr[0].one)

            arr[0] = arr[0].rotate()
        }

        sb.appendLine(if (max == -1) "none" else max)

        if (readln() == "$") break
    }

    print(sb)
}

fun calc(num: Int, cnt: Int, sum: Int, start: Int) {
    if (cnt == 6) {
        if (num == start) max = maxOf(max, sum)
        return
    }

    for (i in 0..5) {
        if (isUsed[i]) continue

        for (j in 0..2) {
            if (arr[i].check(num)) {
                isUsed[i] = true
                calc(arr[i].three, cnt + 1, sum + arr[i].two, start)
                isUsed[i] = false
            }

            arr[i] = arr[i].rotate()
        }
    }
}