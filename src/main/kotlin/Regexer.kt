fun main() {
    var a: String
    a = "Aboot 1,234 pigs"
    var b = Regex("[^0-9]")
    var c = b.replace(a, "")
    println("Replacement results: $c")
}