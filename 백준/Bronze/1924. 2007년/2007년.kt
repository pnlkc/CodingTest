import java.time.LocalDate

fun main() {
    val (x, y) = readln().split(" ").map { it.toInt() }
    val date = LocalDate.of(2007, x, y).dayOfWeek

    println(
        when (date.value) {
            1 -> "MON"
            2 -> "TUE"
            3 -> "WED"
            4 -> "THU"
            5 -> "FRI"
            6 -> "SAT"
            else -> "SUN"
        }
    )
}