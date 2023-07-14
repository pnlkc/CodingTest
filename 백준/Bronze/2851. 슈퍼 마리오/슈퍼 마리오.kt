fun main() {
    var sum = 0
    for (i in 1..10) {
        var newSum = sum + readln().toInt()
        if (newSum <= 100) sum = newSum
        else {
            if(newSum - 100 <= 100 - sum) sum = newSum
            break
        }
    }
    println(sum)
}