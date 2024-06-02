data class Pos(val x: Int, val y: Int, val dir: Char)

fun main() {
    val (A, B) = readln().split(" ").map { it.toInt() }
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(B) { IntArray(A) }
    val robotMap = mutableMapOf<Int, Pos>()
    val dirMap = mutableMapOf(
        'N' to intArrayOf(0, 1),
        'E' to intArrayOf(1, 0),
        'S' to intArrayOf(0, -1),
        'W' to intArrayOf(-1, 0),
    )
    val dirArr = arrayOf('N', 'E', 'S', 'W')

    for (i in 1..N) {
        val (x, y, dir) = readln().split(" ")

        map[y.toInt() - 1][x.toInt() - 1] = i
        robotMap[i] = Pos(x.toInt() - 1, y.toInt() - 1, dir[0])
    }

    for (i in 1..M) {
        val (r, c, n) = readln().split(" ")

        for (j in 1..n.toInt()) {
            val robot = robotMap[r.toInt()]!!

            when (c[0]) {
                'L' -> {
                    var newDir = dirArr.indexOf(robot.dir) - 1
                    while (newDir < 0) {
                        newDir += 4
                    }
                    robotMap[r.toInt()] = robot.copy(dir = dirArr[newDir])
                }
                'R' -> {
                    var newDir = dirArr.indexOf(robot.dir) + 1
                    newDir %= 4
                    robotMap[r.toInt()] = robotMap[r.toInt()]!!.copy(dir = dirArr[newDir])
                }
                'F' -> {
                    val nx = robot.x + dirMap[robot.dir]!!.first()
                    val ny = robot.y + dirMap[robot.dir]!!.last()

                    if (nx < 0 || ny < 0 || nx >= A || ny >= B) {
                        println("Robot $r crashes into the wall")
                        return
                    }

                    if (map[ny][nx] != 0) {
                        println("Robot $r crashes into robot ${map[ny][nx]}")
                        return
                    }

                    map[robot.y][robot.x] = 0
                    map[ny][nx] = r.toInt()
                    robotMap[r.toInt()] = Pos(nx, ny, robot.dir)
                }
            }
        }
    }
    
    println("OK")
}