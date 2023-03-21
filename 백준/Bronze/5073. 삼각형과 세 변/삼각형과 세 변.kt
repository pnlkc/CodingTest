fun main() {
    while (true) {
        val l = readln().takeIf { it != "0 0 0" }?.let { it.split(" ").map { it.toInt() }.sorted() } ?: break
        val lSize = l.distinct().size

        println(
            when {
                l[0] + l[1] <= l[2] -> "Invalid"
                lSize == 1 -> "Equilateral "
                lSize == 2 -> "Isosceles"
                else -> "Scalene"
            }
        )
    }
}