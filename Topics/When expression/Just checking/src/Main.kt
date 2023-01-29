fun main() {
    val input = readln().toInt()

    when(input) {
        2 -> println("Yes!")
        in 1..4 -> println("No!")
        else -> println("Unknown number")
    }
}