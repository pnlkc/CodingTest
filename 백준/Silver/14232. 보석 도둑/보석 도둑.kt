import kotlin.math.sqrt

fun main() {
    val k = readln().toLong()
    val sqrt = sqrt(k.toDouble()).toLong()
    val result = mutableListOf<Long>()
    var temp = k

    for (num in 2..sqrt) {

        while (temp % num == 0L) {
            result.add(num)
            temp /= num
        }
    }

    if (temp != 1L) result.add(temp)

    println(result.size)
    println(result.joinToString(" "))
}