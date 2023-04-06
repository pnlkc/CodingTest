fun main() {
    val input = readln() + "+0"
    var result = 0
    var existMinus = false

    input.fold("") { acc, c ->
        if (c.isDigit()) acc + c
        else {
            if (existMinus) result -= acc.toInt() else result += acc.toInt()
            "".also { if (c == '-') existMinus = true }
        }
    }

    println(result)
}