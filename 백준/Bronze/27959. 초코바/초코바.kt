fun main() {
   val (N, M) = readln().split(" ").map { it.toInt() }
   
   println(if (N * 100 >= M) "Yes" else "No")
}