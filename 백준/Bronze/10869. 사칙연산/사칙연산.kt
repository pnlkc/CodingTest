fun main() {
    readLine()!!.split(" ").run {
        println(this[0].toInt() + this[1].toInt())
        println(this[0].toInt() - this[1].toInt())
        println(this[0].toInt() * this[1].toInt())
        println(this[0].toInt() / this[1].toInt())
        println(this[0].toInt() % this[1].toInt())
    }
}