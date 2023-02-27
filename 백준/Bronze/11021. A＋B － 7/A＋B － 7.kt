fun main() {
    for (i in 1..readln().toInt()) {
        println("Case #$i: ${readln().split(" ").sumOf { it.toInt() }}")
    }    
}