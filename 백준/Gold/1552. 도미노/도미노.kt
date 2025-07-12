var N = 6
var arr = Array(6) { IntArray(6) }
var pick = Array(6) { BooleanArray(6) }
var pickNum = BooleanArray(6)
var min = Int.MAX_VALUE
var max = Int.MIN_VALUE
var checkNum = false

fun main() {
    N = readln().toInt()
    arr = Array(N) { IntArray(N) }
    pick = Array(N) { BooleanArray(N) }
    pickNum = BooleanArray(N)

    for (i in 0 until N) {
        val input = readln()

        for (j in 0 until N) {
            arr[i][j] = if (input[j].isDigit()) {
                input[j].digitToInt()
            } else {
                (input[j] - 'A' + 1) * -1
            }
        }
    }

    calc(0, 1)

    println(min)
    println(max)
}

fun calc(y: Int, num: Int) {
    if (y == N) {
        var cnt = 0
        val isCheck = BooleanArray(N)
        var result = num

        for (i in 0 until N) {
            for (j in 0 until N) {
                if (pick[i][j] && !isCheck[i]) {
                    checkNum = false
                    check(i, j, i, isCheck)

                    if (checkNum) cnt++
                }
            }
        }
        
        if (cnt % 2 == 0) result *= -1
        min = minOf(min, result)
        max = maxOf(max, result)
        return
    }

    for (i in 0 until N) {
        if (pickNum[i]) continue

        pickNum[i] = true
        pick[y][i] = true
        calc(y + 1, num * arr[y][i])
        pickNum[i] = false
        pick[y][i] = false
    }
}

fun check(s: Int, x: Int, y: Int, isCheck: BooleanArray) {
    if (s == x) {
        checkNum = true
        return
    }

    for (i in 0 until N) {
        if (pick[x][i]) {
            isCheck[x] = true
            check(s, i, x, isCheck)
        }
    }
}