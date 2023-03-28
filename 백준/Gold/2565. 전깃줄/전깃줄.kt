fun main() {
    val tcNum = readln().toInt()
    val arr = Array(tcNum) { readln().split(" ").map { it.toInt() }.toIntArray() + intArrayOf(1) }

    // 왼쪽 기둥 번호를 기준으로 오름차순 정렬
    arr.sortBy { it[0] }

    for (n in 1 until tcNum) {
        arr[n][2] += arr
            .filterIndexed { i, ints -> i <= n && ints[0] < arr[n][0] && ints[1] < arr[n][1] }
            .maxOfOrNull { it[2] } ?: 0
    }

    println(tcNum - arr.maxOf { it[2] })
}
