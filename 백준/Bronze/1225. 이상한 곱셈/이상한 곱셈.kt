fun main() {
    val (a, b) = readln().split(' ')
    val aSum = a.map(Char::digitToInt).sum()
    val bSum = b.map(Char::digitToInt).sum()
    println(aSum.toLong() * bSum)
}