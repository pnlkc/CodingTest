fun main() {
    val target = readln().toInt()
    for (i in 1..target) {
        val sum = i + i.toString().sumOf { it.digitToInt() }
        if (sum == target) {
            return println(i)
        }
    }
    println(0)
}