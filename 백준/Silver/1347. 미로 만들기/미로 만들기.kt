fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val command = readln()
    val list = mutableListOf<Pair<Int, Int>>()
    var x = 0
    var y = 0
    var dir = 0
    var minX = 0
    var minY = 0
    var maxX = 0
    var maxY = 0
    val dx = intArrayOf(0, -1, 0, 1)
    val dy = intArrayOf(-1, 0, 1, 0)

    list.add(0 to 0)

    for (c in command) {
        when (c) {
            'F' -> {
                x += dx[dir]
                y += dy[dir]
                maxX = maxOf(maxX, x)
                maxY = maxOf(maxY, y)
                minX = minOf(minX, x)
                minY = minOf(minY, y)
                list.add(x to y)
            }
            'R' -> dir = (dir + 1) % 4
            'L' -> dir = (dir + 3) % 4
        }
    }

    val map = Array(maxY - minY + 1) { CharArray(maxX - minX + 1) { '#' } }

    for ((cx, cy) in list) {
        map[cy - minY][cx - minX] = '.'
    }

    for (i in maxY - minY downTo 0) {
        sb.appendLine(map[i].joinToString(""))
    }

    print(sb)
}