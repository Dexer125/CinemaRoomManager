fun main() {
    // put your code here
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val d = readln().toInt()
    val range = 0..1000

    for (i in range) {
        if (a * (i * i * i) + b * (i * i) + c * i + d == 0) {
            println(i)
        }

    }
}