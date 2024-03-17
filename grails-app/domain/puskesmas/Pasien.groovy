package puskesmas

class Pasien {
    String namaPasien
    JenisKelamin jenisKelamin
    String alamat
    String nomorTelepon


    static hasMany = [rekamMedis: RekamMedis]
    static belongsTo = [jenisKelamin: JenisKelamin]
    static constraints = {
    }

    String toString() {
        return namaPasien
    }
}
