import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun main() {
    val input = readln()
    val formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm", Locale.ENGLISH)
    val dateTime = LocalDateTime.parse(input, formatter)
    val days = if (dateTime.year % 400 == 0 || (dateTime.year % 4 == 0 && dateTime.year % 100 != 0)) 366 else 365
    val dayResult = (dateTime.dayOfYear - 1) / days.toDouble()
    val timeResult = (dateTime.hour * 60 + dateTime.minute).toDouble() / (days * 24 * 60)
    
    println((dayResult + timeResult) * 100)
}