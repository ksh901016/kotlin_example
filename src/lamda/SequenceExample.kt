package lamda

fun main(){
    listOf(1, 2, 3, 4).asSequence()
        .map { print("map($it) "); it * it }
        .filter{ print("filter($it) "); it % 2 ==0}
        .toList()
    println()
    listOf(1, 2, 3, 4)
        .map { print("map($it) "); it * it }
        .filter{ print("filter($it) "); it % 2 ==0}
        .toList()

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())
}