package rocks.aendu.kotlin

fun main() {
    val myName = "Samuel L. Jackson"
    println("Hello $myName")
    println("What is max: ${max(2, 3)}")
    val languages = mutableListOf("Java")
    languages.add("Kotlin")
    println(languages)
    val firstPerson = Person(myName, false)
    println(firstPerson)
    println(firstPerson.name)
    println(firstPerson.isStudent)
    val square = Rectangle(200, 200)
    println("Is square: ${square.isSquare}")
    println(Color.BLUE.rgb)
    // 255
    Color.GREEN.printColor()
    println(getMnemonic(Color.BLUE))
    println(getWarmthFromSensor())
    println(mix(Color.BLUE, Color.VIOLET))
    for (i in 1..100) {
        print(fizzBuzz(i))
    }
    println()
    iterateMap()
    println()
    binaryRepo()
    println()
    listWithIndex()
    println()
    checkIfSomethingIsInTheRange()
}


fun max(a: Int, b: Int) = if (a > b) a else b

class Person(val name: String, var isStudent: Boolean)

class Rectangle(height: Int, width: Int) {
    val isSquare: Boolean = height == width
}

enum class Color(
    val r: Int,
    val g: Int,
    val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    val rgb = (r * 256 + g) * 256 + b
    fun printColor() = println("$this is $rgb")
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun measureColor() = Color.ORANGE

fun getWarmthFromSensor(): String = when (val color = measureColor()) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm (red = ${color.r})"
    Color.GREEN -> "neutral (green = ${color.g})"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold (blue = ${color.b})"
}

// as a stand-in for more complex measurement logic
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }

private fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun iterateMap() {
    val collection = listOf("red", "green", "blue")
    for (color in collection) {
        print("$color ")
    }
    // red green blue
}

fun binaryRepo() {

    val binaryReps = mutableMapOf<Char, String>()
    for (char in 'A'..'F') {
        val binary = char.code.toString(radix = 2)
        binaryReps[char] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
    // A = 1000001    D = 1000100
    // B = 1000010    E = 1000101
    // C = 1000011    F = 1000110
    // (output split into columns for conciseness)
}

fun listWithIndex() {
    val list = listOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
    // 0: 10
    // 1: 11
    // 2: 1001
}

fun checkIfSomethingIsInTheRange() {
    println("Kotlin" in "Java".."Scala")
    // true
}
