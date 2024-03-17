package puskesmas

class JenisKelamin {
    String jenisKelamin

    static hasMany = [pasien: Pasien]
    static constraints = {
    }

    String toString() {
        return jenisKelamin 
    }
}