package typesystem

fun showProgress(progress: Int){
    val percent = progress.coerceIn(0, 100)
    println("We're ${percent}% done!")
}

data class PersonTest(val name:String, val age:Int? = null){
    fun isOlderThan(other: PersonTest): Boolean?{
        if(age == null || other.age == null){
            return null
        }
        return age > other.age
    }
}

fun main(){
    showProgress(146)

    println(PersonTest("SAM", 35).isOlderThan(PersonTest("Amy", 42)))
    println(PersonTest("SAM").isOlderThan(PersonTest("Amy")))

    val x = 1
    val list = listOf(1L, 2L, 3L)
    x.toLong() in list
}