import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import kotlin.math.pow
import kotlin.math.roundToInt

fun main() {
    val N = readln().toInt()

    if (N == 0) {
        println(0)
        return
    }

    val arr = Array(N) { "" }
    var t = 0.0
    var b = 0.0

    for (i in 0 until N) {
        arr[i] = readln()
    }

    val (lastDay, lastTime, ll) = arr[N - 1].split(" ")

    for (i in 0 until N) {
        val (day, time, l) = arr[i].split(" ")

        val fm = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
        val date1 = LocalDateTime.parse("$day $time", fm)
        val date2 = LocalDateTime.parse("$lastDay $lastTime", fm)

        val secondsDiff = ChronoUnit.SECONDS.between(date1, date2).toDouble()
        val yearDiff = secondsDiff / (365 * 24 * 60 * 60)

        val p = maxOf(0.5.pow(yearDiff), 0.9.pow(N - 1 - i))

        t += p * l.toInt()
        b += p
    }

    println((t / b).roundToInt())
}