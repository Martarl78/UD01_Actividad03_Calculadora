fun main() {
    var seleccion: Int

    do {
        imprimirMenu()
        seleccion = pedirOpcion()

        when (seleccion) {
            1, 2, 3, 4, 5 -> {
                val n1 = pedirNumero("Introduce el primer número: ")
                val n2 = pedirNumero("Introduce el segundo número: ")

                when (seleccion) {
                    1 -> println("El resultado de la suma es: ${n1 + n2}")
                    2 -> println("El resultado de la resta es: ${n1 - n2}")
                    3 -> println("El resultado de la multiplicación es: ${n1 * n2}")
                    4 -> {
                        if (n2 == 0.0) {
                            println("Error: no se puede dividir entre cero.")
                        } else {
                            println("El resultado de la división es: ${n1 / n2}")
                        }
                    }
                    5 -> {
                        if (n2 == 0.0) {
                            println("Error: no se puede calcular el resto con el segundo número igual a cero.")
                        } else {
                            println("El resultado del resto es: ${n1 % n2}")
                        }
                    }
                }
            }
            6 -> println("Calculadora cerrada. ¡Hasta luego!")
            else -> println("Opción no válida. Elige una opción del 1 al 6.")
        }

        println()
    } while (seleccion != 6)
}

fun imprimirMenu() {
    println("===== CALCULADORA BÁSICA =====")
    println("1. Sumar")
    println("2. Restar")
    println("3. Multiplicar")
    println("4. Dividir")
    println("5. Calcular resto")
    println("6. Salir")
    print("Seleccione una opción: ")
}

// Si el usuario escribe algo que no es un número, devuelve -1
fun pedirOpcion(): Int {
    return readlnOrNull()?.trim()?.toIntOrNull() ?: -1
}

// Repite la petición hasta que se introduce un número válido
fun pedirNumero(texto: String): Double {
    while (true) {
        print(texto)
        val valor = readlnOrNull()?.trim()?.replace(',', '.')?.toDoubleOrNull()
        if (valor != null) {
            return valor
        }
        println("Error: introduce un número válido.")
    }
}