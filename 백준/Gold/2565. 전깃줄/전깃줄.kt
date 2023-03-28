fun main() {
    val tcNum = readln().toInt()
    val arr = Array(tcNum) { readln().split(" ").map { it.toInt() }.toIntArray() + intArrayOf(1) }

    // 왼쪽 기둥 번호를 기준으로 오름차순 정렬
    arr.sortBy { it[0] }

    for (i in 1 until tcNum) {
        val filter = arr.slice(0..i).filter { it[0] < arr[i][0] && it[1] < arr[i][1] }
        if (filter.isNotEmpty()) arr[i][2] = filter.maxOf { it[2] } + 1
    }

    println(tcNum - arr.maxOf { it[2] })
}
