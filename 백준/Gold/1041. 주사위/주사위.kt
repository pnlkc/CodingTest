fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val minOne = list.min()
    val minTwo = minTwo(list)
    val minThree = minThree(list)

    if (N == 1) {
        println(minFive(list))
        return
    }

    println(
        (minThree.toLong() * 4) // 상단 4 꼭지점
                + (minTwo.toLong() * (N - 2) * 4) // 상단 4 변
                + (minTwo.toLong() * (N - 1) * 4) // 측면 4변
                + (minOne.toLong() * (N - 2) * (N - 2)) // 상단 나머지 공간
                + (minOne.toLong() * (N - 2) * (N - 1) * 4) // 4 측면 나머지 공간
    )
}

fun minFive(list: List<Int>) = list.sum() - list.max()

fun minThree(list: List<Int>): Int {
    return minOf(
        list[0] + list[1] + list[2],
        list[0] + list[1] + list[3],
        list[1] + list[5] + list[2],
        list[1] + list[5] + list[3],
        list[0] + list[4] + list[2],
        list[0] + list[4] + list[3],
        list[4] + list[5] + list[2],
        list[4] + list[5] + list[3],
    )
}

fun minTwo(list: List<Int>): Int {
    return minOf(
        list[0] + list[1],
        list[0] + list[2],
        list[0] + list[3],
        list[0] + list[4],
        list[1] + list[2],
        list[1] + list[3],
        list[1] + list[5],
        list[4] + list[5],
        list[2] + list[4],
        list[3] + list[4],
        list[2] + list[5],
        list[3] + list[5],
    )
}