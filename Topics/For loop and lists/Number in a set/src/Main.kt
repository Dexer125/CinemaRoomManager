fun main() {
    val numbers = readln().toInt()
    val list = mutableListOf<Int>()

    for (i in 1..numbers) {
        list.add(readln().toInt())
    }
    val mNumber = readln().toInt()

    if (list.contains(mNumber)) {
        println("YES")
    } else {
        println("NO")
    }
}