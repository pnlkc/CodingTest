fun main() {
    val map = mapOf(
        "black" to intArrayOf(0, 1),
        "brown" to intArrayOf(1, 10),
        "red" to intArrayOf(2, 100),
        "orange" to intArrayOf(3, 1_000),
        "yellow" to intArrayOf(4, 10_000),
        "green" to intArrayOf(5, 100_000),
        "blue" to intArrayOf(6, 1_000_000),
        "violet" to intArrayOf(7, 10_000_000),
        "grey" to intArrayOf(8, 100_000_000),
        "white" to intArrayOf(9, 1_000_000_000),
    )

    println("${map[readln()]!![0]}${map[readln()]!![0]}".toLong() * map[readln()]!![1])
}