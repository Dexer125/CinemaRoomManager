fun main() {
    // write your code here
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()

    if (a + b > c && b + c > a && c + a > b){
        println("YES")
    }
    else{
        println("NO")
    }
}