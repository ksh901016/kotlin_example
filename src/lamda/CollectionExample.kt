package lamda

data class Person(val name: String, val age: Int)
data class Book(val title: String, val authors: List<String>)
fun main() {
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it%2 == 0 })

    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.filter { it.age > 30 })

    println(list.map { it * it})
    println(people.map(Person::name))
    // 연쇄시킬 수도 있다.
    println(people.filter { it.age > 30 }.map(Person::name))

    val canBeInClub29 = {p : Person -> p.age <= 29}
    val peopleList = listOf(Person("corn", 31), Person("hyebin", 27))
    println(peopleList.all(canBeInClub29))
    println(peopleList.any(canBeInClub29))
    println(peopleList.count(canBeInClub29))
    println(peopleList.find(canBeInClub29))

    val peopleGroupList = listOf(Person("corn", 31), Person("sunghyun", 31), Person("hyebin", 27))
    println(peopleGroupList.groupBy { it.age })

    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })

    val books = listOf(Book("Thursday next", listOf("Jasper Fforde")),
                        Book("Mort", listOf("Terry Pratchett")),
                        Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman")))
    println(books.flatMap{ it.authors }.toSet())

    people.asSequence()
        .map(Person::name)
        .filter { it.startsWith("A") }
        .toList()
    println(people.asSequence().iterator().forEach { println(it) })
}