package typesystem

import java.lang.IllegalArgumentException

fun strLen(s: String) = s.length
fun strLenSafe(s: String?): Int =
    if(s != null) s.length else 0
fun strLenSafe2(s: String?): Int = s?.length ?: 0

fun printAllCaps(s: String?){
    val allCaps: String? = s?.toUpperCase()
    println(allCaps)
}

class Employee(val name: String, val manager: Employee?)
fun managerName(employee: Employee): String? = employee.manager?.name

class Address(val streetAddress: String, val zipCode: Int,
                val city: String, val country: String)
class Company(val name: String, val address: Address?)
class Person(val name: String, val company: Company?)

fun Person.countryName(): String {
    // 여러 안전한 호출 연산자를 연쇄해 사용
    val country = this.company?.address?.country
    return if (country != null) country else "Unknown"
}

fun Person.countryName2(): String = company?.address?.country ?: "Unknown"
fun printlnShippingLabel(person: Person){
    val address = person.company?.address
        ?: throw IllegalArgumentException("No address")
    with(address){
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

fun main(){
    strLen("Hello")
    strLenSafe(null)
    strLenSafe2(null)

    printAllCaps("abc")
    printAllCaps(null)

    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob smith", ceo)
    println(managerName(developer))
    println(managerName(ceo))

    //val person = Person("Corn", null)
    //println(person.countryName())
    //println(person.countryName2())

    val address = Address("청계산로", 0, "서울시", "한국")
    val cornCompany = Company("corn's Company", address)
    val person = Person("Corn", cornCompany)
    printlnShippingLabel(person)

    printlnShippingLabel(Person("Sunghyun", null))
}