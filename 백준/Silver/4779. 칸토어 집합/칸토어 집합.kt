import java.util.*

fun main() = with(Scanner(System.`in`)) {
    while (hasNextInt()) {
        var num = 1
        repeat(nextInt()) {
            num *= 3
        }

        var string = CharArray(num) { '-' }.joinToString("")
        string = calc(string, 0, num - 1)

        println(string)
    }
}

fun calc(string: String, s: Int, e: Int): String {
    if (string.length < 3) return string

    val r = (e - s + 1) / 3
    val a = calc(string.slice(s until s + r), 0, r - 1)
    val b = CharArray(r) { ' ' }.joinToString("")
    val c = calc(string.slice(s + r + r..e), 0, r - 1)

    return a + b + c
}