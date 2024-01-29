class Tiempo(private var hora: Int, private var minuto: Int = 0, private var segundo: Int = 0) {

    init {
        if (hora >= 24) throw IllegalArgumentException("Hora debe ser menor que 24")
        if (minuto >= 60 || segundo >= 60) {
            minuto += segundo / 60
            segundo %= 60
            hora += minuto / 60
            minuto %= 60
            hora %= 24
        }
    }

    fun incrementar(t: Tiempo): Boolean {
        val totalSegundos = this.totalSegundos() + t.totalSegundos()
        if (totalSegundos > 86399) {
            return false
        }
        this.hora = totalSegundos / 3600
        this.minuto = (totalSegundos % 3600) / 60
        this.segundo = totalSegundos % 60
        return true
    }

    fun decrementar(t: Tiempo): Boolean {
        val totalSegundos = this.totalSegundos() - t.totalSegundos()
        if (totalSegundos < 0) {
            return false
        }
        this.hora = totalSegundos / 3600
        this.minuto = (totalSegundos % 3600) / 60
        this.segundo = totalSegundos % 60
        return true
    }

    fun comparar(t: Tiempo): Int {
        return this.totalSegundos().compareTo(t.totalSegundos())
    }

    fun copiar(): Tiempo {
        return Tiempo(hora, minuto, segundo)
    }

    fun copiar(t: Tiempo) {
        this.hora = t.hora
        this.minuto = t.minuto
        this.segundo = t.segundo
    }

    fun sumar(t: Tiempo): Tiempo? {
        val totalSegundos = this.totalSegundos() + t.totalSegundos()
        if (totalSegundos > 86399) {
            return null
        }
        return Tiempo(totalSegundos / 3600, (totalSegundos % 3600) / 60, totalSegundos % 60)
    }

    fun restar(t: Tiempo): Tiempo? {
        val totalSegundos = this.totalSegundos() - t.totalSegundos()
        if (totalSegundos < 0) {
            return null
        }
        return Tiempo(totalSegundos / 3600, (totalSegundos % 3600) / 60, totalSegundos % 60)
    }

    fun esMayorQue(t: Tiempo): Boolean {
        return this.totalSegundos() > t.totalSegundos()
    }

    fun esMenorQue(t: Tiempo): Boolean {
        return this.totalSegundos() < t.totalSegundos()
    }

    private fun totalSegundos(): Int {
        return hora * 3600 + minuto * 60 + segundo
    }

    override fun toString(): String {
        return "${hora.toString().padStart(2, '0')}h ${minuto.toString().padStart(2, '0')}m ${segundo.toString().padStart(2, '0')}s"
    }
}
