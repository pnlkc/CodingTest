fun main() {
    val N = readln().toInt()
    val map = Array(N) { CharArray(N) { ' ' } }
    var row = 0
    var column = 0

    for (i in 0 until N) {
        val str = readln()

        for (j in 0 until N) {
            map[i][j] = str[j]
        }
    }

    for  (i in 0 until N) {
        var cnt = 0

        for (j in 0 until N) {
            if (map[i][j] == '.') {
                if (++cnt == 2) {
                    row++
                }
            } else {
                cnt = 0
            }
        }
    }

    for  (i in 0 until N) {
        var cnt = 0

        for (j in 0 until N) {
            if (map[j][i] == '.') {
                if (++cnt == 2) {
                    column++
                }
            } else {
                cnt = 0
            }
        }
    }

    println("$row $column")
}