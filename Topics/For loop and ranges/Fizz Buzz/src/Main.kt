fun main() {
    // put your code here
    val first = readln().toInt()
    val last = readln().toInt()
    val fizz = "Fizz"
    val buzz = "Buzz"
    val fizzBuzz = "FizzBuzz"

    for (i in first..last) {

        if (i % 3 == 0) {
            if (i % 5 == 0) {
                println(fizzBuzz)
            } else {
                println(fizz)
            }

        } else if (i % 5 == 0) {
            if (i % 3 == 0) {
                println(fizzBuzz)
            } else {
                println(buzz)
            }

        } else {
            println(i)
        }
    }
}