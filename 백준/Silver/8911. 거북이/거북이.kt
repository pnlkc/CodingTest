data class Pos(val x: Int, val y: Int, val dir: Int)

fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val pArr = intArrayOf(0, 0, 0, 0)
        var c = Pos(0, 0, 0)
        val dir = arrayOf(Pos(0, -1, 0), Pos(1, 0, 1), Pos(0, 1, 2), Pos(-1, 0, 3))
        val input = readln()

        for (command in input) {
            when (command) {
                'F' -> c = c.copy(x = c.x + dir[c.dir].x, y = c.y + dir[c.dir].y)
                'B' -> c = c.copy(x = c.x - dir[c.dir].x, y = c.y - dir[c.dir].y)
                'L' -> c = c.copy(dir = (c.dir + 3) % 4)
                'R' -> c = c.copy(dir = (c.dir + 1) % 4)
            }
            
            pArr[0] = minOf(c.y, pArr[0])
            pArr[1] = maxOf(c.x, pArr[1])
            pArr[2] = maxOf(c.y, pArr[2])
            pArr[3] = minOf(c.x, pArr[3])
        }

        sb.appendLine((pArr[2] - pArr[0]) * (pArr[1] - pArr[3]))
    }

    print(sb)
}