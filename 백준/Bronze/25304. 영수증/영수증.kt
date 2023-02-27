import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val sum1 = nextLine().toInt()
    val num = nextLine().toInt()
    var sum2 = 0

    repeat(num) {
        val input = nextLine().split(" ").map { it.toInt() }
        sum2 += input[0] * input[1]
    }

    when {
        sum1 != sum2 -> println("No")
        else -> println("Yes")
    }
}