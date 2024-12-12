fun main() {
   val (T, S) = readln().split(" ").map { it.toInt() }

   println(if (S == 1 || T !in 12..16) 280 else 320)
}