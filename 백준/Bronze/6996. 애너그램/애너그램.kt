fun main() {
    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ")

        if (a.toCharArray().sortedArray().joinToString("") == b.toCharArray().sortedArray().joinToString("")) {
            println("$a & $b are anagrams.")
        } else {
            println("$a & $b are NOT anagrams.")
        }
    }
}