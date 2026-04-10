fun main() {
    val t = readln().toInt()

    repeat(t) {
        val (h, w) = readln().split(" ").map { it.toDouble() }

        println(
            when {
                h < 140.1 -> 6
                h < 146.0 -> 5
                h < 159.0 -> 4
                h < 161 -> if (calc(h, w) in 16.0..<35.0) 3 else 4
                h < 204 -> {
                    val r = calc(h, w)

                    when (r) {
                        in 20.0..<25.0 -> 1
                        in 18.5..<20.0, in 25.0..<30.0 -> 2
                        in 16.0..<18.5, in 30.0..<35.0 -> 3
                        else -> 4
                    }
                }

                else -> 4
            }
        )

    }
}

fun calc(h: Double, w: Double): Double = w / ((h / 100) * (h / 100))