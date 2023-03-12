fun main() {
    while (true) {
        val input = readln().toInt()
        if (input == 0) break

        var count = 0
        
        p@for (i in input + 1..input * 2) {
            if (i < 1) continue
            for (j in 2..i) {
                if (j * j > i) {
                    count++
                    continue@p
                }

                if (i % j == 0) continue@p
            }
        }
        
        println(count)
    }
}