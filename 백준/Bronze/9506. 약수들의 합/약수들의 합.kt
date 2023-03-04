fun main() {
    while (true) {
        val input = readln().toInt()
        if (input == -1) break

        val array = mutableListOf<Int>()
        for (i in 1 until input) {
            if (input % i == 0) array.add(i)
        }

        if (array.sum() == input) {
            println("$input = " + array.joinToString(" + "))
        } else {
            println("$input is NOT perfect.")
        }
    }
}