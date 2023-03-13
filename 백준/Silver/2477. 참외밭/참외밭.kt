fun main() {
    val num = readln().toInt()
    val list = mutableListOf<List<Int>>()
    repeat(6) {
        list.add(readln().split(" ").map { it.toInt() })
    }

    // 입력값들을 좌표로 변경
    val posList = mutableListOf<List<Int>>()
    val pos = intArrayOf(0, 0)
    list.forEach {
        when (it[0]) {
            1 -> pos[0] = pos[0] + it[1]
            2 -> pos[0] = pos[0] - it[1]
            3 -> pos[1] = pos[1] - it[1]
            else -> pos[1] = pos[1] + it[1]
        }
        posList.add(pos.toList())
    }

    // 큰 사각형 값 구하기
    val min = listOf(posList.minOf { it[0] }, posList.minOf { it[1] })
    val max = listOf(posList.maxOf { it[0] }, posList.maxOf { it[1] })
    val bigSquare = (max[0] - min[0]) * (max[1] - min[1])

    // 작은 사각형 값 구하기
    val center = posList.find { it[0] != min[0] && it[0] != max[0] && it[1] != min[1] && it[1] != max[1] }!!
    val noExist = listOf(min, max, listOf(min[0], max[1]), listOf(max[0], min[1]))
        .filter { vl -> posList.count { it[0] == vl[0] && it[1] == vl[1]} == 0 }[0]
    val smallSquare = (center[0] - noExist[0]) * (center[1] - noExist[1])

    // 큰 사각형 - 작은 사각형 = 참외 밭의 넓이
    // 1m^2에서 자라는 참외 수 * 참외 밭의 넓이 = 밭에서 자라는 참외의 수
    println(num * (bigSquare - if (smallSquare < 0) smallSquare * -1 else smallSquare))
}