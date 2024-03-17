package puskesmas

class RekamMedis {
    String kodeRM
    String keluhan
    String diagnosa
    Date tanggalPeriksa
    Pasien pasien
    Obat obat
    Poliklinik poliklinik
    Dokter dokter

    static belongsTo = [pasien: Pasien, obat: Obat, poliklinik: Poliklinik, dokter: Dokter]
    static constraints = {
    }

    String toString() {
        return kodeRM
    }
}