fun main() {
    var input =  readLine()!!.split(" ")
    var input1 = input.first().toInt()
    var input2 = input.last().toInt()
    when {
       input2 < 45 -> {
           input1 -= 1
           when {
               input1 < 0 -> input1 += 24
           }
           input2 += 15
           println("$input1 $input2")
       }
        input2 >= 45 -> {
            input2 -= 45
            println("$input1 $input2")
        }
    }
}