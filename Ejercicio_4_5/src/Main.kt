import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Ingrese la hora (0-23):")
    val hora = scanner.nextInt()

    println("¿Desea ingresar minutos? (s/n):")
    val ingresarMinutos = scanner.next()
    val minuto = if (ingresarMinutos.equals("s", ignoreCase = true)) {
        println("Ingrese los minutos (0-59):")
        scanner.nextInt()
    } else {
        0
    }

    println("¿Desea ingresar segundos? (s/n):")
    val ingresarSegundos = scanner.next()
    val segundo = if (ingresarSegundos.equals("s", ignoreCase = true)) {
        println("Ingrese los segundos (0-59):")
        scanner.nextInt()
    } else {
        0
    }

    try {
        val tiempo = Tiempo(hora, minuto, segundo)
        println("Tiempo ingresado: $tiempo")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
