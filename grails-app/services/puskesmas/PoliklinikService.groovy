package puskesmas

import grails.gorm.services.Service

@Service(Poliklinik)
interface PoliklinikService {

    Poliklinik get(Serializable id)

    List<Poliklinik> list(Map args)

    Long count()

    void delete(Serializable id)

    Poliklinik save(Poliklinik poliklinik)

}