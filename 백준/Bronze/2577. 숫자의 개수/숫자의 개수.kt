fun main() {
    val n = (readln().toInt() * readln().toInt() * readln().toInt()).toString()
    ('0'..'9').forEach { i -> println(n.count { it == i }) }
}