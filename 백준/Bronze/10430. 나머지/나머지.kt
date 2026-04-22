fun main() {
    readLine()!!.split(" ").apply {
        val A = this[0].toInt()
        val B = this[1].toInt()
        val C = this[2].toInt()
        println( (A + B) % C )
        println( ( (A % C) + (B % C)) % C )
        println( (A * B) % C)
        println( ((A % C) * (B % C)) % C )
    }
}