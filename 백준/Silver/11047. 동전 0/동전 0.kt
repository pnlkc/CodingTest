fun main() {
    var (n, k) = readln().split(" ").map { it.toInt() }
    val list = List(n) { readln().toInt() }.sortedDescending()
    println(list.fold(0) { acc, i -> if (k >= i) (acc + k / i).also { k %= i } else acc })
}