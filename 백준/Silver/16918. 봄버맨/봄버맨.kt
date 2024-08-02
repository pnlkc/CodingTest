fun main() {
    val sb = StringBuilder()
    val (R, C, N) = readln().split(" ").map { it.toInt() }
    var map = Array(R) { IntArray(C) }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    for (i in 0 until R) {
        val input = readln().toCharArray()

        for (j in 0 until C) {
            map[i][j] = if (input[j] == '.') 0 else 1
        }
    }

    if (N < 2) {
        for (i in 0 until R) {
            sb.appendLine(map[i].map { if (it == 0) '.' else 'O' }.joinToString(""))
        }

        print(sb)
        return
    }

    var time = 1
    var type = 1

    while (time < N) {
        time++

        if (time % 2 == 0) {
            val next = if (type == 1) 2 else 1

            for (i in 0 until R) {
                for (j in 0 until C) {
                    if (map[i][j] == 0) map[i][j] = next
                }
            }
        } else {
            val temp = Array(R) { IntArray(C) }
            copy(map, temp)

            for (i in 0 until R) {
                for (j in 0 until C) {
                    if (map[i][j] == type) {
                        temp[i][j] = 0

                        for (d in 0..3) {
                            val nx = j + dx[d]
                            val ny = i + dy[d]

                            if (nx < 0 || nx >= C || ny < 0 || ny >= R) continue

                            temp[ny][nx] = 0
                        }
                    }
                }
            }

            map = temp
            type = if (type == 1) 2 else 1
        }
    }

    for (i in 0 until R) {
        sb.appendLine(map[i].map { if (it == 0) '.' else 'O' }.joinToString(""))
    }

    print(sb)
}

fun copy(ori: Array<IntArray>, dest: Array<IntArray>) {
    for (i in ori.indices) {
        for (j in ori[0].indices) {
            dest[i][j] = ori[i][j]
        }
    }
}