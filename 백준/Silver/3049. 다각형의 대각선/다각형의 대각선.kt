fun main() {
    val N = readln().toInt()
    var top = 1
    var bottom = 1

    for (i in 1..4){
        top *= N - i + 1
        bottom *= i
    }

    println(top / bottom)
}