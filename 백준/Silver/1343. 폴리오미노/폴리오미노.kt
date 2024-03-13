fun main() {
    var board = readln()

    while (board.contains("XXXX")) {
        board = board.replace("XXXX", "AAAA")
    }

    while (board.contains("XX")) {
        board = board.replace("XX", "BB")
    }

    println(if (board.contains('X')) -1 else board)
}