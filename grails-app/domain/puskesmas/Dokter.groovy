package puskesmas

class Dokter {
    String namaDokter
    String spesialis
    String alamat
    String nomorTelepon
    JenisKelamin jenisKelamin


    static hasMany = [rekamMedis: RekamMedis]
    static belongsTo = [jenisKelamin: JenisKelamin]

    static constraints = {
        rekamMedis display:false
    }

    String toString() {
        return namaDokter
    }
}
