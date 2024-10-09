package rocks.aendu.kotlin

fun main() {
    val person = listOf(
        Person("Hubert", false),
        Person("Lisa", true)
    )

    // No intermediate collections are created!
    val filtered = person.asSequence().map { it.name }.filter { it.startsWith("L") }
    println(filtered.toList())

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())
    // 5050
}

