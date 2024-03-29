package puskesmas

class Obat {
    String namaObat
    String keterangan
    Integer hargaObat
    Integer stok
    JenisObat jenisObat

    static hasMany = [rekamMedis: RekamMedis] 
    static belongsTo = [jenisObat: JenisObat]
    static constraints = {
        rekamMedis display:false
    }

    String toString() {
        return namaObat
    }
}
