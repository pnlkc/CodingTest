fun main() {
    val num = readln().toInt()
    val arr = readln().split(" ").map { intArrayOf(it.toInt(), 1, 1) }

    // 증가
    for (i in 0 until num) {
        arr[i][1] += arr
            .filterIndexed { idx, ints -> idx < i && ints[0] < arr[i][0] }
            .maxOfOrNull { it[1] } ?: 0
    }

    // 감소
    for (i in num - 1 downTo 0) {
        arr[i][2] += arr
            .filterIndexed { idx, ints -> idx > i && ints[0] < arr[i][0] }
            .maxOfOrNull { it[2] } ?: 0
    }

    println(arr.maxOf { it[1] + it[2] - 1 })
}