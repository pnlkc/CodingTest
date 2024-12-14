fun main() {
   val input = readln()

   println(
      when (input) {
         "NLCS" -> "North London Collegiate School"
         "BHA" -> "Branksome Hall Asia"
         "KIS" -> "Korea International School"
         else -> "St. Johnsbury Academy"
      }
   )
}