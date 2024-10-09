package rocks.aendu.kotlin

fun main() {
    val person = listOf(
        Person("Hubert", false),
        Person("Lisa", true)
    )

    // No intermediate collections are created!
    val filtered = person.asSequence().map { it.name }.filter { it.startsWith("L") }
    println(filtered.toList())
}

