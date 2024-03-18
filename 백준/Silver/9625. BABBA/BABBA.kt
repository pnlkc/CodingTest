fun main() {
    val K = readln().toInt()
    val arr = mutableListOf(1 to 0)

    for (i in 1..K) {
        val (a, b) = arr.last()

        arr.add(b to (a + b))
    }

    println("${arr.last().first} ${arr.last().second}")
}