package puskesmas

class Poliklinik {
    String namaPoli
    String gedung

    static hasMany = [rekamMedis: RekamMedis]
    static constraints = {}

    String toString() {
        return namaPoli
    }
}
