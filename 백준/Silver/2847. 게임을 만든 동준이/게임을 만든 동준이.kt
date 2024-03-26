fun main() {
    val N = readln().toInt()
    val list = mutableListOf<Int>()
    var result = 0

    for (i in 1..N) {
        list.add(readln().toInt())
    }

    for (i in list.lastIndex downTo 1) {
        if (list[i] <= list[i - 1]) {
            result += list[i - 1] - list[i] + 1
            list[i - 1] = list[i] - 1
        }
    }

    println(result)
}