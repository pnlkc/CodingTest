fun main() {
    val map = mutableMapOf<String, String>(
        "000000" to "A", "001111" to "B", "010011" to "C", "011100" to "D",
        "100110" to "E", "101001" to "F", "110101" to "G", "111010" to "H",
    )
    val list = listOf(
        "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010",
    )
    val N = readln().toInt()
    val str = readln()
    var result = ""

    p@ for (i in 0 until N) {
        for (char in list) {
            var cnt = 0

            for (j in 0..5) {
                if (str[i * 6 + j] != char[j]) cnt++
            }

            if (cnt <= 1) {
                result += map[char]!!
                continue@p
            }
        }

        println(i + 1)
        return
    }

    println(result)
}
