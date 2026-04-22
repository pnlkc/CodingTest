fun main() {
    var input = readLine()!!.split(" ")
    var a = input[0].toInt()
    var b = input[1].toInt()
    var c = input[2].toInt()

    when {
        a == b && b == c -> println(10000 + a*1000)
        a == b && a != c || a == c && a != b || b == c && b != a -> {
            when {
                a == b -> println(1000 + a * 100)
                b == c -> println(1000 + b * 100)
                a == c -> println(1000 + a * 100)
            }
        }
        a != b && b != c && a != c -> {
            when {
                a > b && a > c -> println(a * 100)
                b > a && b > c -> println(b * 100)
                c > a && c > b ->println(c * 100)
            }
        }
    }
}