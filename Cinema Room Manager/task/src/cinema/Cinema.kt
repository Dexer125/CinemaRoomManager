package cinema
const val MENU = """
        1. Show the seats
        2. Buy a ticket
        3. Statistics
        0. Exit
"""
fun main() {
    val seatRows = mutableListOf(mutableListOf<String>())
    val currentIncome = mutableListOf<Int>()
    var rows1 = 0
    var seats1 = 0
    var purchasedTickets = 0
    println("Enter the number of rows:")
    print("> ")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    print("> ")
    val seats = readln().toInt()
    println()
    seatsGenerate(rows, seats, rows1, seats1, seatRows)
    println(MENU.trimIndent())
    print("> ")
    var userChoice = 1

    while (userChoice != 0) {

        if (userChoice != 2) {
            userChoice = readln().toInt()
        }


        when (userChoice) {
            1 -> {
                println()
                seatsPrint(rows, seats, seatRows)
            }
            2 -> {
                println()
                println("Enter a row number:")
                print("> ")
                rows1 = readln().toInt()
                println("Enter a seat number in that row:")
                print("> ")
                seats1 = readln().toInt()
                println()
                if (rows1 <= rows && seats1 <= seats && seatRows[rows1][seats1] != " B") {
                        costOfTheTicket(rows1, rows, seats, currentIncome)
                        seatsGenerate(rows, seats, rows1, seats1, seatRows)
                        purchasedTickets++
                    userChoice = 4
                    }
                else if (rows1 < 0 || seats1 < 0 || rows1 > rows || seats1 > seats) {
                    println("Wrong input!")
                    userChoice = 2
                }
                else {
                    println("That ticket has already been purchased!")
                    userChoice = 2
                }

            }
            3 -> statistics(rows, seats, purchasedTickets, currentIncome)
            0 -> return
        }
        if (userChoice != 2) {
            println()
            println(MENU.trimIndent())
            print("> ")
        }


    }


}

fun totalIncome (rows: Int, seats: Int) {

    val income: Int
    if (rows * seats <= 60) {
        income = rows * seats * 10
        println("Total income: $$income")
    } else if (rows * seats >= 60 && (rows * seats) % 2 > 0) {
        income = (rows / 2) * seats * 10 + ((rows / 2) + 1) * seats * 8
        println("Total income: $$income")
    } else {
        income = ((rows * seats / 2) * 10) + ((rows * seats / 2) * 8)
        println("Total income: $$income")
    }
}

fun costOfTheTicket (rows1: Int, rows: Int, seats: Int, currentIncome: MutableList<Int>) {

    if (rows * seats <= 60) {
        print("Ticket price: ")
        println("$10")
        currentIncome.add(10)
    } else if (rows * seats >= 60 && rows / 2 > rows1) {
        print("Ticket price: ")
        println("$10")
        currentIncome.add(10)
    } else if (rows * seats >= 60 && rows / 2 < rows1) {
        print("Ticket price: ")
        println("$8")
        currentIncome.add(8)
    } else {
        print("Ticket price: ")
        println("$10")
        currentIncome.add(10)
    }
}

fun seatsGenerate (rows: Int, seats: Int, rows1: Int, seats1: Int, seatRows : MutableList<MutableList<String>>) {

    if (rows1 == 0) {
        seatRows[0].add(0," ")
    }

    for (i in 1.. seats) {
        seatRows[0].add(" $i")
    }

    for (i in 1..rows) {
        seatRows.add(mutableListOf())
        seatRows[i].add(i.toString())
        for (j in 1..seats) {
            seatRows[i].add(" S")
        }

    }
    if (seatRows[rows1][seats1] != " B" && rows1 > 0 && seats1 > 0 ) {
        seatRows[rows1].add(seats1, " B")
        }


}

fun seatsPrint (rows: Int, seats: Int, seatRows : MutableList<MutableList<String>>) {

    println("Cinema:")

    for (k in 0..rows) {
        for (l in 0..seats) {
            print(seatRows[k][l])

        }
        println()
    }
}

fun statistics (rows: Int, seats: Int, purchasedTickets: Int, currentIncome: MutableList<Int>) {
    val percentage = purchasedTickets.toDouble() / (rows.toDouble() * seats.toDouble()) * 100.0
    val formatPercentage = "%.2f".format(percentage)
    var currentIncomeFinal = 0
    for (i in 0..currentIncome.lastIndex) {
        currentIncomeFinal += currentIncome[i]
    }
    println()
    println("Number of purchased tickets: $purchasedTickets")
    println("Percentage: $formatPercentage%")
    println("Current income: $$currentIncomeFinal")
    totalIncome(rows, seats)
    println()

}
