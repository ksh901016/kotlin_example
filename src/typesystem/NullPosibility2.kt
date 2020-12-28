package typesystem

fun verifyUserInput(input: String?){
    if(input.isNullOrBlank()){
        println("Please fill in the required fields")
    }
}

// 널이 될 수 있는 String 의 확장
// 코틀린에서는 this 가 null 이 될 수 있다.
fun String?.isNullOrBlank(): Boolean = this == null || this.isBlank();

fun<T> printHashCode(t: T){
    // t가 null이 될 수 있으므로, 안전한 호출을 써야한다.
    println(t?.hashCode())
}
fun<T: Any> printHashCode2(t: T){
    // 상한(upper bound)를 지정하면, null이 아님을 확실히한다.
    println(t.hashCode())
}

fun main(){
    verifyUserInput(" ")
    verifyUserInput(null)
    printHashCode(null)
    //printHashCode2(null) // 컴파일 에러
    printHashCode2(42)
}