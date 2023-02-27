import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var num = nextInt()
    var string = "int"
    repeat(num / 4) {
        string = "long " + string
    }
    println(string)
}