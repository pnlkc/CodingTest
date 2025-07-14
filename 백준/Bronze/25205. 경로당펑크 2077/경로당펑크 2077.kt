fun main() {
    val n = readln().toInt()
    val s = readln()
    val consonant = charArrayOf('q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v')

    println(if (!consonant.contains(s[n - 2]) && consonant.contains(s[n - 1])) 1 else 0)
}