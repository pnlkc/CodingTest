fun main() {
    val num = readln().toInt()
    val arr = readln().split(" ").map { intArrayOf(it.toInt(), 1) }

    for (i in 1 until num) {
        val filter = arr.slice(0..i).filter { it[0] < arr[i][0] }
        if (filter.isNotEmpty()) arr[i][1] = filter.maxOf { it[1] } + 1
    }

    println(arr.maxOf { it[1] })
}