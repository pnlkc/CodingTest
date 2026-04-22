fun main() {
    var input1 =  readLine()!!.split(" ")
    var input1a = input1.first().toInt()
    var input1b = input1.last().toInt()
    var input2 = readLine()!!.toInt()

    when {
        input1b + input2 >= 60 -> {
            input1a += (input1b + input2) / 60
            if (input1a >= 24) input1a -= 24
            input1b = input1b + input2 - (60 * ((input1b + input2) / 60))
            println("$input1a $input1b")
        }
        input1b + input2 < 60 -> {
            input1b += input2
            println("$input1a $input1b")
        }
    }
}