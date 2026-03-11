fun main() {
    val n = readln().toInt()
    val s = readln()
    val len = s.length

    println(
        when {
            len <= 25 -> s
            s.drop(11).dropLast(12).contains(".") -> "${s.take(9)}......${s.takeLast(10)}"
            else -> "${s.take(11)}...${s.takeLast(11)}"
        }
    )
}