package puskesmas

class JenisObat {
    String namaJenisObat

    static hasMany = [obat: Obat]
    static constraints = {
        obat display:false
    }

    String toString() {
        return namaJenisObat
    }
}
