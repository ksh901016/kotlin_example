package lamda

import java.lang.StringBuilder

fun alphabet4() = StringBuilder().apply{
    for (letter in 'A'..'Z'){
        append(letter)
    }
    append("\nNow I know the alphabet!")
}.toString()

fun main() {
    print(alphabet4())
}