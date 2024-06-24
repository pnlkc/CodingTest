fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sortedDescending().mapIndexed { idx, i -> i + idx + 1 }

    println(list.maxOrNull()!! + 1)
}