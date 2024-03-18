package puskesmas

class Poliklinik {
    String namaPoli
    String gedung

    static hasMany = [rekamMedis: RekamMedis]
    static constraints = {
        rekamMedis display:false
    }

    String toString() {
        return namaPoli
    }
}
