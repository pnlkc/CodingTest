fun main() {
    val (n, m, l) = readln().split(' ').map(String::toInt)
    val arr = IntArray(n)
    var start = 0
    var count = 0
    arr[0] = 1
    
    while (arr.maxOrNull()!! < m) {
        if (arr[start] % 2 == 0) {
            start -= l
            while (start < 0) {
                start += n
            }
            start %= n
        } else {
            start += l
            start %= n
        }
        arr[start]++
        count++
    }
    
    println(count)
}