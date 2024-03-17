package puskesmas

import grails.gorm.services.Service

@Service(Pasien)
interface PasienService {

    Pasien get(Serializable id)

    List<Pasien> list(Map args)

    Long count()

    void delete(Serializable id)

    Pasien save(Pasien pasien)

}