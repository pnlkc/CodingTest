fun main() {
    val arr = List(readln().toInt()) { readln() }
    
    println(
        ('a'..'z')
            .fold("") { acc, c -> if (arr.count { it[0] == c } >= 5) acc + c else acc }
            .ifEmpty { "PREDAJA" }
    )
}