package lamda

import java.lang.StringBuilder

fun alphabet(): String{
    val result = StringBuilder()
    for(letter in 'A'..'Z'){
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun alphabet2(): String{
    val stringBuilder = StringBuilder()
    // 메소드를 호출하려는 수신 객체를 지정
    return with(stringBuilder){
        for (letter in 'A'..'Z'){
            // this를 명시해서 수신 객체의 메소드 호출
            this.append(letter)
        }
        // this 생략 가능
        append("\nNow I know the alphabet!")
        this.toString()
    }
}
fun alphabet3() = with(StringBuilder()){
    for (letter in 'A'..'Z'){
        // this를 명시해서 수신 객체의 메소드 호출
        this.append(letter)
    }
    // this 생략 가능
    append("\nNow I know the alphabet!")
    this.toString()
}

fun main(){
    println(alphabet())
    println(alphabet2())
    println(alphabet3())
}