fun main() {
    val N = readln().toLong()

    print(if (N % 7 == 0L || N % 7 == 2L) "CY" else "SK")
}