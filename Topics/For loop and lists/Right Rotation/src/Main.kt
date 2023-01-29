fun main() {
    // write your code here
    val n = readln().toInt()
    val numbersList = mutableListOf<Int>()
    val shiftedNumbersList = mutableListOf<Int>()
    for (i in 1..n) {
        numbersList.add(readln().toInt())
    }
    var positions = readln().toInt()
    if (positions % n != 0) {
        positions %= n
    } else {
        positions = 0
    }

    for (i in 1..positions) {
        shiftedNumbersList.add(0, numbersList[numbersList.lastIndex])
        numbersList.removeAt(numbersList.lastIndex)
    }
    shiftedNumbersList += numbersList
    for (i in 0..shiftedNumbersList.lastIndex) {
        print("${shiftedNumbersList[i]} ")
    }
}