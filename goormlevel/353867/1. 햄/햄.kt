fun main() {
  val (x1, y1, r1) = readLine()!!.split(" ").map { it.toLong() }
  val (x2, y2, r2) = readLine()!!.split(" ").map { it.toLong() }
  val diffX = x1 - x2
  val diffY = y1 - y2

  println(if (diffX * diffX + diffY * diffY < (r1 + r2) * (r1 + r2)) "YES" else "NO")
}