var map: Array<IntArray> = arrayOf()

fun main() {
    val (N, M, R) = readln().split(" ").map { it.toInt() }
    map = Array(N) { IntArray(M) }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until M) {
            map[i][j] = input[j]
        }
    }

    val command = readln().split(" ").map { it.toInt() }

    for (c in command) {
        when (c) {
            1 -> one()
            2 -> two()
            3 -> three()
            4 -> four()
            5 -> five()
            6 -> six()
        }
    }

    for (i in map.indices) {
        println(map[i].joinToString(" "))
    }
}

fun one() {
    val newArr = Array(map.size) { IntArray(map[0].size) }

    for (i in map.indices) {
        for (j in map[0].indices) {
            newArr[i][j] = map[map.lastIndex - i][j]
        }
    }

    map = newArr
}

fun two() {
    val newArr = Array(map.size) { IntArray(map[0].size) }

    for (i in map.indices) {
        for (j in map[0].indices) {
            newArr[i][j] = map[i][map[0].lastIndex - j]
        }
    }

    map = newArr
}

fun three() {
    val newArr = Array(map[0].size) { IntArray(map.size) }

    for (i in map.indices) {
        for (j in map[0].indices) {
            newArr[j][map.lastIndex - i] = map[i][j]
        }
    }

    map = newArr
}

fun four() {
    val newArr = Array(map[0].size) { IntArray(map.size) }

    for (i in map.indices) {
        for (j in map[0].indices) {
            newArr[map[0].lastIndex - j][i] = map[i][j]
        }
    }

    map = newArr
}

fun five() {
    val newArr = Array(map.size) { IntArray(map[0].size) }

    val halfX = map[0].size / 2
    val halfY = map.size / 2

    for (i in 0 until halfY) {
        for (j in 0 until halfX) {
            newArr[i][j + halfX] = map[i][j]
        }
    }

    for (i in 0 until halfY) {
        for (j in halfX until map[0].size) {
            newArr[i + halfY][j] = map[i][j]
        }
    }

    for (i in halfY until map.size) {
        for (j in halfX until map[0].size) {
            newArr[i][j - halfX] = map[i][j]
        }
    }

    for (i in halfY until map.size) {
        for (j in 0 until halfX) {
            newArr[i - halfY][j] = map[i][j]
        }
    }

    map = newArr
}

fun six() {
    val newArr = Array(map.size) { IntArray(map[0].size) }

    val halfX = map[0].size / 2
    val halfY = map.size / 2

    for (i in 0 until halfY) {
        for (j in 0 until halfX) {
            newArr[i + halfY][j] = map[i][j]
        }
    }

    for (i in 0 until halfY) {
        for (j in halfX until map[0].size) {
            newArr[i][j - halfX] = map[i][j]
        }
    }

    for (i in halfY until map.size) {
        for (j in halfX until map[0].size) {
            newArr[i - halfY][j] = map[i][j]
        }
    }

    for (i in halfY until map.size) {
        for (j in 0 until halfX) {
            newArr[i][j + halfX] = map[i][j]
        }
    }

    map = newArr
}