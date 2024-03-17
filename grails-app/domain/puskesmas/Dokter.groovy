package puskesmas

class Dokter {
    String namaDokter
    String spesialis
    String alamat
    String nomorTelepon


    static hasMany = [rekamMedis: RekamMedis]
    static belongsTo = [jenisKelamin: JenisKelamin]
    static constraints = {}

    String toString() {
        return namaDokter
    }
}
