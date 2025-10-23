fun main() {
    val (N, K, P, W) = readln().split(" ").map { it.toInt() }

    println((P / W) + if (P % W != 0) 1 else 0)
}