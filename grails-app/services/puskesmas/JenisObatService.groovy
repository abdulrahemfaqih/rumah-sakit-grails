package puskesmas

import grails.gorm.services.Service

@Service(JenisObat)
interface JenisObatService {

    JenisObat get(Serializable id)

    List<JenisObat> list(Map args)

    Long count()

    void delete(Serializable id)

    JenisObat save(JenisObat jenisObat)

}