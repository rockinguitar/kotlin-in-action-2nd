package rocks.aendu.kotlin

fun main() {
    val staffMembers = listOf(Staff("Melina", 22), Staff("James", 60))
    println(staffMembers.maxByOrNull { it.age })
    // or
    println(staffMembers.minBy(Staff::age))
    val sum = { x: Int, y: Int -> x + y }
    println(sum(20, 40))

    // Call a lambda directly
    run { println(42) }
    // 42

    println(staffMembers.joinToString(" ") { p: Staff -> p.name })
    run(::salute)

    val seb = Staff("Sebastian", 26)
    val personsAgeFunction = Staff::age
    println(personsAgeFunction(seb))
    // 26
    val sebsAgeFunction = seb::age
    println(sebsAgeFunction())
    // 26
    val isOdd = IntCondition { it % 2 != 0 }
    println(isOdd.check(1))
    // true
    println(isOdd.checkString("2"))
    // false
    println(isOdd.checkChar('3'))
    // true

    checkCondition(1) { it % 2 != 0 }
    // true
    val isOdd2: (Int) -> Boolean = { it % 2 != 0 }
    checkCondition(1, isOdd2)
    // true

    // with function
    println(withAlphabet())
    println(applyAlphabet())
    println(simplifiedAlphabet())
    showOffAlso()
}

fun showOffAlso() {
    val fruits = listOf("Apple", "Banana", "Cherry")
    val uppercaseFruits = mutableListOf<String>()
    val reversedLongFruits = fruits
        .map { it.uppercase() }
        .also { uppercaseFruits.addAll(it) }
        .filter { it.length > 5 }
        .also { println(it) }
        .reversed()
    // [BANANA, CHERRY]
    println(uppercaseFruits)
    // [APPLE, BANANA, CHERRY]
    println(reversedLongFruits)
    // [CHERRY, BANANA]
}

fun simplifiedAlphabet() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet with buildString!")
}

fun applyAlphabet(): String = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet with apply!")
}.toString()


// with
fun withAlphabet(): String = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet with with!")
    toString()
}


fun interface IntCondition {
    fun check(i: Int): Boolean
    fun checkString(s: String) = check(s.toInt())
    fun checkChar(c: Char) = check(c.digitToInt())
}

fun checkCondition(i: Int, condition: IntCondition) = condition.check(i)

fun salute() = println("Salute!")

data class Staff(val name: String, val age: Int)