fun main() {
    var (n, k) = readln().split(" ").map { it.toInt() }
    val list = List(n) { readln().toInt() }
    println(list.foldRight(0) { i, acc -> if (k >= i) (acc + k / i).also { k %= i } else acc })
}