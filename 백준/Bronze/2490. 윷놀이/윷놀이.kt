fun main() {
    repeat(3) {
        val list = readln().split(" ").map { it.toInt() }

        println(
            when (list.count { it == 0 }) {
                0 -> 'E'
                1 -> 'A'
                2 -> 'B'
                3 -> 'C'
                else -> 'D'
            }
        )
    }
}