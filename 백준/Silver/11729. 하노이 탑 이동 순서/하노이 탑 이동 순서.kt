var answer = mutableListOf<String>()

fun main() {
    val input = readln().toInt()
    moveTower(input, 1, 3)
    println(answer.size)
    println(answer.joinToString("\n"))
}

fun moveTower(size: Int, start: Int, destination: Int) {
    if (size > 0) {
        moveTower(size - 1, start, 6 - start - destination)
        answer.add("$start $destination")
        moveTower(size - 1, 6 - start - destination, destination)
    }
}