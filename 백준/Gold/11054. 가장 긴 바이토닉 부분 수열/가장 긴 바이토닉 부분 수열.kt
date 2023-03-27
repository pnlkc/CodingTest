fun main() {
    val num = readln().toInt()
    val arr = readln().split(" ").map { intArrayOf(it.toInt(), 1, 1, 1) }

    for (i in 1 until num) {
        // 계속 증가
        arr[i][1] += arr
            .filterIndexed { idx, ints -> idx < i && ints[0] < arr[i][0] }
            .maxOfOrNull { it[1] } ?: 0

        // 꺾임
        arr[i][2] += arr
            .filterIndexed { idx, ints -> idx < i && ints[0] < arr[i][0] }
            .maxOfOrNull { it[1] } ?: 0

        // 계속 감소
        arr[i][3] += arr
            .filterIndexed { idx, ints -> idx < i && ints[0] > arr[i][0] }
            .maxOfOrNull { maxOf(it[2], it[3]) } ?: 0
    }

    println(arr.maxOf { maxOf(it[1], it[2], it[3]) })
}