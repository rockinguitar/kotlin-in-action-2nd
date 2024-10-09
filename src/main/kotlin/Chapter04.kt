package rocks.aendu.kotlin

fun main() {
    val mainButton = Button()
    mainButton.click()
    // I was clicked
    mainButton.showOff()
    mainButton.setFocus(true)
    println(ThemedButton())
}

class Button : Clickable, Focusable {
    override fun click() = println("I was clicked")

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!")
}

// open means this can be a base class, standard is final
open class RichButton : Clickable {

    open fun animate() { /* ... */
    }

    override fun click() { /* ... */
    }
}

class ThemedButton : RichButton() {
    override fun animate() { /* ... */
    }

    override fun click() { /* ... */
    }

    override fun showOff() { /* ... */
    }
}

