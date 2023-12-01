fun main() {
    var sum = 0
    
    for (i in 1..5) {
        var num = readln().toInt()
        if (num < 40) num = 40
        sum += num
    }
    
    println(sum / 5)
}