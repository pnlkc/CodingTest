fun main() {
    var answer = 0

    repeat(8) { y ->
        readln().forEachIndexed { x, c ->
            if (y % 2 == 0 && x % 2 == 0 && c == 'F') answer++
            if (y % 2 == 1 && x % 2 == 1 && c == 'F') answer++
        }
    }

    println(answer)
}