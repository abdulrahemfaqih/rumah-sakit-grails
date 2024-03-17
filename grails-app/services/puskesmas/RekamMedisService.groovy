package puskesmas

import grails.gorm.services.Service

@Service(RekamMedis)
interface RekamMedisService {

    RekamMedis get(Serializable id)

    List<RekamMedis> list(Map args)

    Long count()

    void delete(Serializable id)

    RekamMedis save(RekamMedis rekamMedis)

}