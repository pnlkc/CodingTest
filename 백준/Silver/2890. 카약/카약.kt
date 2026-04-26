fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val map = Array(r) { "" }
    val answer = IntArray(9)
    var result = 0
    var cnt = -1

    for (i in 0 until r) {
        map[i] = readln()
    }

    map.sort()

    for (i in 8 downTo 0) {
        var temp = 0
        var num = ' '

        for (j in c - 2 downTo 0) {
            if (map[r - 1 - i][j] != '.') {
                num = map[r - 1 - i][j]
                break
            }

            temp++
        }

        if (temp > cnt) {
            result++
            cnt = temp
        }

        answer[num.digitToInt() - 1] = result
    }

    println(answer.joinToString("\n"))
}