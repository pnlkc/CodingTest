fun main() {
    val (W, H) = readln().split(" ").map { it.toInt() }

    println(String.format("%.1f", W.toDouble() * H / 2))
}