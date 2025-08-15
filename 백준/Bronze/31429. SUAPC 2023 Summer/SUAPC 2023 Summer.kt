fun main() {
    val arr = arrayOf(
        0 to 0, 12 to 1600, 11 to 894, 11 to 1327, 10 to 1311,
        9 to 1004, 9 to 1178, 9 to 1357, 8 to 837, 7 to 1055,
        6 to 556, 6 to 773,
    )
    val N = readln().toInt()

    println("${arr[N].first} ${arr[N].second}")
}