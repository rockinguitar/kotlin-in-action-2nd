package rocks.aendu.kotlin

fun main() {
    fizzBuzz(100).forEach { println(it) }
}

@Suppress("SameParameterValue")
private fun fizzBuzz(rounds: Int): List<String> =
    fizzBuzzSequence().take(rounds).toList()

fun fizzBuzzSequence(): Sequence<String> =
    generateSequence(1L) { it + 1 }.map { round ->
        round.toFizzBuzz()
    }

internal fun Long.toFizzBuzz(): String = when {
    this % 15L == 0L -> "FizzBuzz"
    this % 3L == 0L -> "Fizz"
    this % 5L == 0L -> "Buzz"
    else -> toString()
}