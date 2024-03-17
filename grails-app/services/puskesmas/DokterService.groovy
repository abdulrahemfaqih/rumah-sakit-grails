package puskesmas

import grails.gorm.services.Service

@Service(Dokter)
interface DokterService {

    Dokter get(Serializable id)

    List<Dokter> list(Map args)

    Long count()

    void delete(Serializable id)

    Dokter save(Dokter dokter)

}