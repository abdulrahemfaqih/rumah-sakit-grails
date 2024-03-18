package puskesmas

class JenisKelamin {
    String jenisKelamin

    static hasMany = [pasien: Pasien, dokter: Dokter]

    static constraints = {
        pasien display: false
        dokter display: false
    }

    String toString() {
        return jenisKelamin
    }
}