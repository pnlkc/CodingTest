fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { CharArray(M) }
    val list = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until N) {
        val input = readln()

        for (j in 0 until M) {
            map[i][j] = input[j]
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (map[i][j] != '.') continue
            var isAdd = false

            if (i - 1 < 0 || map[i - 1][j] == '#') {
                if (i + 2 < N && map[i + 1][j] == '.' && map[i + 2][j] == '.') {
                    list.add(i to j)
                    isAdd = true
                }
            }

            if (!isAdd) {
                if (j - 1 < 0 || map[i][j - 1] == '#') {
                    if (j + 2 < M && map[i][j + 1] == '.' && map[i][j + 2] == '.') {
                        list.add(i to j)
                    }
                }
            }
        }
    }

    println(list.size)
    list.forEach { println("${it.first + 1} ${it.second + 1}") }
}