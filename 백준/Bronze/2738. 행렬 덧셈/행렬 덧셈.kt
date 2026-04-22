fun main() {
   val (i, j) = readln().split(" ").map { it.toInt() }
   val array = Array(i) { IntArray(j) { 0 } }
   
    repeat(2) {
       for (k in 0 until i) {
           val input = readln().split(" ").map { it.toInt() }
           for (l in 0 until j) {
               array[k][l] += input[l]
           }
       }
    }
    
    array.forEach { println(it.joinToString(" ")) }
}