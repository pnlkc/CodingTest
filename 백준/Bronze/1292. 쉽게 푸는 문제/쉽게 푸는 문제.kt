fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<Int>()
    var num = 1

    while (list.size < b) {
        repeat(num) {
            list.add(num)
        }

        num++
    }

    println(list.slice(a - 1..<b).sum())
}