import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    val time = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    println(time.format(formatter))
}