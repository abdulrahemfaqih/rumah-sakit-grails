package puskesmas

class JenisObat {
    String namaJenisObat

    static hasMany = [obat: Obat]
    static constraints = {
    }

    String toString() {
        return namaJenisObat
    }
}
