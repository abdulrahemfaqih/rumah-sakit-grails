package puskesmas

class Dokter {
    String namaDokter
    String spesialis
    String alamat
    String nomorTelepon


    static hasMany = [rekamMedis: RekamMedis]
    static constraints = {}

    String toString() {
        return namaDokter
    }
}
