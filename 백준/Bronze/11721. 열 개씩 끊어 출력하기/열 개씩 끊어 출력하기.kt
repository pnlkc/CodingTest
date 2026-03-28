fun main() {
    var str = readln()

    while (str.isNotEmpty()) {
        println(str.take(10))
        str = str.drop(10)
    }

}