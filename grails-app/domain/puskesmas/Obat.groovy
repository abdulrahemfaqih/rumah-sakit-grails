package puskesmas

class Obat {
    String namaObat
    String keterangan
    Integer stok
    JenisObat jenisObat

    static hasMany = [rekamMedis: RekamMedis] 
    static belongsTo = [jenisObat: JenisObat]
    static constraints = {}

    String toString() {
        return namaObat
    }
}
