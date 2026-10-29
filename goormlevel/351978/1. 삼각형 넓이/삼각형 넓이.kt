fun main() {
    val (w, h) = readLine()!!.trim().split(" ").map { it.toInt() }

    println(String.format("%.1f", w.toDouble() * h / 2))
}