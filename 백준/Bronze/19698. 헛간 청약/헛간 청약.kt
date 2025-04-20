fun main() {
    val (N, W, H, L) = readln().split(" ").map { it.toInt() }

    println(minOf(N, (W / L) * (H / L)))
}