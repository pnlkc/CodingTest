fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val set = setOf(a, b, c)

    println(
        when {
            a + b + c != 180 -> "Error"
            set.size == 1 -> "Equilateral"
            set.size == 2 -> "Isosceles"
            else -> "Scalene"
        }
    )
}