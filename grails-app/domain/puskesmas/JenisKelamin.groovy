package puskesmas

class JenisKelamin {
    String jenisKelamin

    static hasMany = [pasien: Pasien, dokter: Dokter]
    static constraints = {
    }

    String toString() {
        return jenisKelamin
    }
}