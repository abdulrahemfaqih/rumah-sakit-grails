package puskesmas

import grails.gorm.services.Service

@Service(Obat)
interface ObatService {

    Obat get(Serializable id)

    List<Obat> list(Map args)

    Long count()

    void delete(Serializable id)

    Obat save(Obat obat)

}